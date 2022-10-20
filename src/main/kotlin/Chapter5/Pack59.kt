package Chapter5

import java.util.*

object Pack59 {
    val visited = Array(9) { false }
    val graph = ArrayList<ArrayList<Int>>()

    private fun bfs(start: Int) {
        val q: Queue<Int> = LinkedList()
        q.offer(start)
        visited[start] = true
        while (!q.isEmpty()) {
            //큐에서 하나의 원소를 뽑아 출력
            val x = q.poll()
            print("$x ")
            for (i in 0 until graph[x].size) {
                val y = graph[x][i]
                if (!visited[y]) {
                    q.offer(y)
                    visited[y] = true
                }
            }
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        for (i in 0 until 9)
            graph.add(ArrayList())

        // 노드 1에 연결된 노드 정보 저장
        graph[1].add(2)
        graph[1].add(3)
        graph[1].add(8)

        // 노드 2에 연결된 노드 정보 저장

        // 노드 2에 연결된 노드 정보 저장
        graph[2].add(1)
        graph[2].add(7)

        // 노드 3에 연결된 노드 정보 저장

        // 노드 3에 연결된 노드 정보 저장
        graph[3].add(1)
        graph[3].add(4)
        graph[3].add(5)

        // 노드 4에 연결된 노드 정보 저장

        // 노드 4에 연결된 노드 정보 저장
        graph[4].add(3)
        graph[4].add(5)
        // 노드 5에 연결된 노드 정보 저장
        // 노드 5에 연결된 노드 정보 저장
        graph[5].add(3)
        graph[5].add(4)
        // 노드 6에 연결된 노드 정보 저장
        // 노드 6에 연결된 노드 정보 저장
        graph[6].add(7)
        // 노드 7에 연결된 노드 정보 저장
        // 노드 7에 연결된 노드 정보 저장
        graph[7].add(2)
        graph[7].add(6)
        graph[7].add(8)
        // 노드 8에 연결된 노드 정보 저장
        graph[8].add(1)
        graph[8].add(7)
        bfs(1)
    }
}