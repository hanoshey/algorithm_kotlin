import java.util.*

object Pack44 {
    var n = 0
    var m = 0
    var x = 0
    var y = 0
    var direction = 0

    // 방문한 위치를 저장하기 위한 맵을 생성하여 0으로 초기화
    var d = Array(50) { IntArray(50) }

    // 전체 맵 정보
    var arr = Array(50) { IntArray(50) }

    // 북, 동, 남, 서 방향 정의
    var dx = intArrayOf(-1, 0, 1, 0)
    var dy = intArrayOf(0, 1, 0, -1)

    // 왼쪽으로 회전
    fun turn_left() {
        direction -= 1
        if (direction == -1) direction = 3
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)

        // N, M을 공백을 기준으로 구분하여 입력받기
        n = sc.nextInt()
        m = sc.nextInt()

        // 현재 캐릭터의 X 좌표, Y 좌표, 방향을 입력받기
        x = sc.nextInt()
        y = sc.nextInt()
        direction = sc.nextInt()
        d[x][y] = 1 // 현재 좌표 방문 처리

        // 전체 맵 정보를 입력 받기
        for (i in 0 until n) {
            for (j in 0 until m) {
                arr[i][j] = sc.nextInt()
            }
        }

        // 시뮬레이션 시작
        var cnt = 1
        var turn_time = 0
        while (true) {
            // 왼쪽으로 회전
            turn_left()
            var nx = x + dx[direction]
            var ny = y + dy[direction]
            // 회전한 이후 정면에 가보지 않은 칸이 존재하는 경우 이동
            if (d[nx][ny] == 0 && arr[nx][ny] == 0) {
                d[nx][ny] = 1
                x = nx
                y = ny
                cnt += 1
                turn_time = 0
                continue
            } else turn_time += 1
            // 네 방향 모두 갈 수 없는 경우
            if (turn_time == 4) {
                nx = x - dx[direction]
                ny = y - dy[direction]
                // 뒤로 갈 수 있다면 이동하기
                if (arr[nx][ny] == 0) {
                    x = nx
                    y = ny
                } else break
                turn_time = 0
            }
        }
        println(cnt)
    }
}