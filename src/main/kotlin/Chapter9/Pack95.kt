package Chapter9

import java.util.PriorityQueue
import java.util.Scanner
import kotlin.math.max

data class Node4(val index: Int, val distance: Int) : Comparable<Node4> {
    override fun compareTo(other: Node4): Int {
        if (distance < other.distance) return -1
        return 1
    }
}

object Pack95 {
    val INF = 1e9.toInt()
    var n = 0
    var m = 0
    var start = 0
    val graph = ArrayList<ArrayList<Node4>>()
    val d = IntArray(30001)
    fun dijkstra(start: Int) {
        val pq = PriorityQueue<Node4>()
        pq.offer(Node4(start, 0))
        d[start] = 0
        while (!pq.isEmpty()) {//큐가 비어있지 않다면
            val node = pq.poll()
            val dist = node.distance
            val now = node.index
            if (d[now] < dist) continue
            for (i in graph[now].indices) {
                val cost = d[now] + graph[now][i].distance
                if (cost < d[graph[now][i].index]) {
                    d[graph[now][i].index] = cost
                    pq.offer(Node4(graph[now][i].index, cost))
                }
            }
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        n = sc.nextInt()
        m = sc.nextInt()
        start = sc.nextInt()
        for (i in 0..n)
            graph.add(ArrayList())
        //모든 간선 정보를 입력하기
        for (i in 0 until m) {
            val x = sc.nextInt()
            val y = sc.nextInt()
            val z = sc.nextInt()
            //X번 노드에서 Y번 노드로 가는 비용이 Z
            graph[x].add(Node4(y, z))
        }
        d.fill(INF)
        dijkstra(start)
        //도달할 수 있는 노드의 개수
        var count = 0
        //도달할 수 있는 노드 중에서, 가장 멀리 있는 노드와의 최단 거리
        var maxDistance = 0
        for (i in 1..n)//도달할 수 있는 노드인 경우
            if (d[i] != INF) {
                count += 1
                maxDistance = max(maxDistance, d[i])
            }
        //시작 노드는 제외해야 하므로 count-1을 입력
        println("${count - 1} $maxDistance")
    }
}