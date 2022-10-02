import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.abs

class Position3(val x: Int, val y: Int)
object Pack137 {
    //땅의 크기(N), L, R 값을 입력받기
    var n = 0
    var l = 0
    var r = 0
    var totalCount = 0

    //전체 나라의 정보(N X N)
    val graph = Array(50) { IntArray(50) }

    //방문한 나라의 정보(N X N)
    val unions = Array(50) { IntArray(50) }

    //방향 정보
    val dx = intArrayOf(-1, 0, 1, 0)
    val dy = intArrayOf(0, -1, 0, 1)

    //특정 위치에서 출발하여 모든 연합을 체크한 뒤에 데이터 갱신
    fun process(x: Int, y: Int, index: Int) {
        //(x,y)의 위치와 연결된 나라(연합) 정보를 담는 리스트
        val united = ArrayList<Position3>()
        united.add(Position3(x, y))
        //BFS를 위한 큐 라이브러리 사용
        val q: Queue<Position3> = LinkedList()
        q.offer(Position3(x, y))
        unions[x][y] = index //현재 연합의 번호 할당
        var summary = graph[x][y]//현재 연합의 전체 인구 수
        var count = 1//현재 연합의 국가 수
        //큐가 빌 때까지 반복(BFS)
        while (!q.isEmpty()) {
            val pos = q.poll()
            val x = pos.x
            val y = pos.y
            //현재 위치에서 4가지 방향을 확인하며
            for (i in 0 until 4) {
                val nx = x + dx[i]
                val ny = y + dy[i]
                //바로 옆에 있는 나라를 확인하며
                if (nx in 0 until n && ny in 0 until n&& unions[nx][ny]==-1) {
                    //옆에 있는 나라와 인구 차이가 L명 이상, R명 이하라면
                    val gap = abs(graph[nx][ny] - graph[x][y])
                    if (gap in l..r) {
                        q.offer(Position3(nx, ny))
                        //연합에 추가하기
                        unions[nx][ny] = index
                        summary += graph[nx][ny]
                        count += 1
                        united.add(Position3(nx, ny))
                    }
                }
            }
        }
        //연합 국가끼리 인구를 분배
        for (i in united)
            graph[i.x][i.y] = summary / count
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        n = sc.nextInt()
        l = sc.nextInt()
        r = sc.nextInt()
        for (i in 0 until n)
            for (j in 0 until n)
                graph[i][j] = sc.nextInt()
        //더 이상 인구 이동을 할 수 없을 때까지 반복
        while (true) {
            for (i in 0 until n)
                for (j in 0 until n)
                    unions[i][j] = -1
            var index = 0
            for (i in 0 until n)
                for (j in 0 until n)
                    if (unions[i][j] == -1) {
                        //해당 나라가 아직 처리되지 않았다면
                        process(i, j, index)
                        index += 1
                    }
            //모든 인구 이동이 끝난 경우
            if (index == n * n) break
            totalCount += 1
        }
        // 인구 이동 횟수 출력
        println(totalCount)
    }
}