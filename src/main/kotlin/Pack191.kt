import java.util.*

class Fish(val x: Int, val y: Int)
object Pack191 {
    val INF = 1e9.toInt()
    //맵의 크기 N
    var n = 0
    //맵 정보
    val array = Array(20) { IntArray(20) }
    //상어의 현재 위치
    var shark = Fish(0, 0)
    //상어의 현재 크기
    var sharkSize = 2
    //상어가 먹은 물고기의 수
    val dx = intArrayOf(-1, 0, 1, 0)
    val dy = intArrayOf(0, 1, 0, -1)
    var ate = 0
    fun bfs(): Array<IntArray> {
        val q: Queue<Fish> = LinkedList()
        //값이 -1이라면 도달할 수 없다는 의미
        val dist = Array(20) { IntArray(20) { -1 } }
        //시작 위치는 도달이 가능하다고 보며 거리는 0
        dist[shark.x][shark.y] = 0
        q.offer(shark)
        while (q.isNotEmpty()) {
            val now = q.poll()
            //현재 위치에서 4가지 방향으로의 위치 확인
            for (i in 0 until 4) {
                val nx = now.x + dx[i]
                val ny = now.y + dy[i]
                //맵의 범위를 벗어나는 경우 무시
                if (nx in 0 until n && ny in 0 until n)
                //자신의 크기보다 작거나 같은 경우에 지나갈 수 있음
                    if (dist[nx][ny] == -1 && array[nx][ny] <= sharkSize) {
                        dist[nx][ny] = dist[now.x][now.y] + 1
                        q.offer(Fish(nx, ny))
                    }
            }
        }
        return dist
    }

    fun find(dist: Array<IntArray>): Triple<Int, Int, Int> {
        var x = 0
        var y = 0
        var minDist = INF
        for (i in 0 until n)
            for (j in 0 until n)
            //도달이 가능하면서 먹을 수 있는 물고기일 때
                if (dist[i][j] != -1 && 1 <= array[i][j] && array[i][j] < sharkSize)
                //가장 가까운 물고기 한 마리만 선택
                    if (dist[i][j] < minDist) {
                        x = i
                        y = j
                        minDist = dist[i][j]
                    }
        return if (minDist == INF) Triple(-1, -1, -1)
        else Triple(x, y, minDist)
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        n = sc.nextInt()
        for (i in 0 until n)
            for (j in 0 until n) {
                array[i][j] = sc.nextInt()
                if (array[i][j] == 9) {
                    shark = Fish(i, j)
                    array[i][j] = 0
                }
            }
        var result = 0
        while (true) {
            //먹을 수 있는 물고기의 위치 찾기
            val value = find(bfs())
            val x = value.first
            val y = value.second
            val dist = value.third
            //더 이상 먹을 수 있는 물고기가 없는 경우, 현재까지 움직인 거리 출력
            if (dist == -1) {
                println(result)
                break
            } else {
                //현재 위치 갱신 및 이동 거리 변경
                shark = Fish(x, y)
                result += value.third
                //먹은 위치에는 이제 아무것도 없도록 처리
                array[x][y] = 0
                //먹은 물고기 수 증가
                ate++
                //자신의 현재 크기 이상으로 먹은 경우, 크기 증가
                if (ate >= sharkSize) {
                    sharkSize++
                    ate = 0
                }
            }
        }
    }
}