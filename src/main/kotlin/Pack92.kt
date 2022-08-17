import java.util.*
import kotlin.collections.ArrayList

data class Node3(val index: Int, val distance: Int) : Comparable<Node3> {
    override fun compareTo(other: Node3): Int {
        if (distance < other.distance)
            return -1
        return 1
    }

}

object Pack92 {
    val INF = 1e9.toInt()

    //노드의 개수 N, 간선의 개수(M), 시작 노드 번호(Start)
    val graph = ArrayList<ArrayList<Node3>>()
    val d = IntArray(100001)
    fun dijkstra(start: Int) {
        val pq = PriorityQueue<Node3>()
        //시작 노드로 가기 위한 최단 경로는 0으로 설정하여 큐에 삽입
        pq.offer(Node3(start, 0))
        d[start] = 0
        while (!pq.isEmpty()) {//큐가 비어있지 않다면
            //가장 최단 거리가 짧은 노드에 대한 정보 꺼내기
            val node = pq.poll()
            val dist = node.distance//현재 노드까지의 비용
            val now = node.index//현재 노드
            //현재 노드가 이미 처리된 적이 있는 노드라면 무시
            if (d[now] < dist) continue//현재 노드와 연결된 다른 인접한 노드들을 확인
            for (i in graph[now].indices) {
                val cost = d[now] + graph[now][i].distance
                if (cost < d[graph[now][i].index]) {
                    d[graph[now][i].index] = cost
                    pq.offer(Node3(graph[now][i].index, cost))
                }
            }
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        val n = sc.nextInt()
        val m = sc.nextInt()
        val start = sc.nextInt()
        //그래프 초기화
        for (i in 0..n)
            graph.add(ArrayList())
        //모든 간선 정보를 입력받기
        for (i in 0 until m) {
            val a = sc.nextInt()
            val b = sc.nextInt()
            val c = sc.nextInt()
            graph[a].add(Node3(b, c))
        }
        d.fill(INF)
        dijkstra(start)
        for (i in 1..n) {
            if (d[i] == INF)
                println("INFINITY")
            else
                println(d[i])
        }
    }
}