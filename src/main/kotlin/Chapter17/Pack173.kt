package Chapter17

import java.util.*

private class Node9(val x: Int, val y: Int, val distance: Int) : Comparable<Node9> {
    override fun compareTo(other: Node9): Int {
        return if (distance < other.distance) -1 else 1
    }
}

private object Pack173 {
    val INF = 1e9.toInt()
    val graph = Array(125) { IntArray(125) }
    val d = Array(125) { IntArray(125) }
    var testCase = 0
    var n = 0
    val dx = intArrayOf(-1, 0, 1, 0)
    val dy = intArrayOf(0, 1, 0, -1)

    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        testCase = sc.nextInt()
        //전체 테스트 케이스만큼 반복
        for (tc in 0 until testCase) {
            //노드의 개수를 입력받기
            n = sc.nextInt()
            //전체 맵 정보를 입력받기
            for (i in 0 until n)
                for (j in 0 until n)
                    graph[i][j] = sc.nextInt()
            //최단거리 테이블을 모두 무한으로 초기화
            for (i in 0 until n)
                d[i].fill(INF)
            var x = 0
            var y = 0
            //시작 위치는 (0,0)
            val pq = PriorityQueue<Node9>()
            pq.offer(Node9(x, y, graph[x][y]))
            d[x][y] = graph[x][y]
            while (pq.isNotEmpty()) {//다익스트라 알고리즘을 수행
                //가장 최단 거리가 짧은 노드에 대한 정보 꺼내기
                val node = pq.poll()
                val dist = node.distance
                x = node.x
                y = node.y
                //현재 노드가 이미 처리된 적이 있는 노드라면 무시
                if (d[x][y] < dist) continue
                //현재 노드와 연결된 다른 인접한 노드들을 확인
                for (i in 0 until 4) {
                    val nx = x + dx[i]
                    val ny = y + dy[i]
                    //맵을 벗어나는 경우 무시
                    if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue
                    //현재 노드를 거쳐서 다른 노드로 이동하는 거리 계산
                    val cost = dist + graph[nx][ny]
                    //현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우
                    if (cost < d[nx][ny]) {
                        d[nx][ny] = cost
                        pq.offer(Node9(nx, ny, cost))
                    }
                }
            }
            println(d[n - 1][n - 1])
        }
    }
}