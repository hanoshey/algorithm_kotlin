import java.util.LinkedList
import java.util.Queue
import java.util.Scanner

private data class Node1(private val x: Int, private val y: Int) {
    fun getX(): Int = this.x
    fun getY(): Int = this.y
}


object Pack511 {
    var n = 0
    var m = 0
    val graph = Array(201) { IntArray(201) }
    //네 가지 방향 정의  상, 하, 좌, 우
    val dx = intArrayOf(-1, 1, 0, 0)
    val dy = intArrayOf(0, 0, -1, 1)
    fun bfs(x: Int, y: Int): Int {
        var x = x
        var y = y
        val q: Queue<Node1> = LinkedList()
        q.offer(Node1(x, y))
        while (!q.isEmpty()) {
            val node = q.poll()
            x = node.getX()
            y = node.getY()
            //현재 위치에서 4가지 방향으로 위치 확인
            for (i in 0 until 4) {
                val nx = x + dx[i]
                val ny = y + dy[i]
                //미로 찾기 공간 벗어난 경우 무시
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue
                //벽이 경우 무시
                if (graph[nx][ny] == 0) continue
                //해당 노드를 처음 방문하는 경우에만 최단 거리 기록
                if (graph[nx][ny] == 1) {
                    graph[nx][ny] = graph[x][y] + 1
                    q.offer(Node1(nx, ny))
                }
            }
        }
        return graph[n - 1][m - 1]
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        n = sc.nextInt()
        m = sc.nextInt()
        sc.nextLine()//버퍼 비우기
        //2차원 리스트의 맵 정보 입력받기
        for (i in 0 until n) {
            val str = sc.nextLine()
            for (j in 0 until m)
                graph[i][j] = str[j] - '0'
        }
        println(bfs(0, 0))
    }
}