package Chapter17

import java.util.*
import kotlin.collections.ArrayList

private class Node10(val index: Int, val distance: Int) : Comparable<Node10> {
    //거리(비용)이 짧은 것이 높은 우선순위를 가지도록 설정
    override fun compareTo(other: Node10): Int {
        return if (distance < other.distance) -1 else 1
    }
}

private object Pack174 {
    val INF = 1e9.toInt()

    //노드의 개수(N), 간선의 개수(M)
    var n = 0
    var m = 0

    //시작 노드를 1번 헛간으로 설정
    var start = 1

    //각 노드에 연결되어 있는 노드에 대한 정보를 담는 리스트를 만들기
    val graph = ArrayList<ArrayList<Node10>>()

    //최단 거리 테이블 만들기
    val d = IntArray(20001)

    fun dijkstra(start: Int) {
        val pq = PriorityQueue<Node10>()
        //시작 노드로 가기 위한 최단 경로는 0으로 설정하여, 큐에 삽입
        pq.offer(Node10(start, 0))
        d[start] = 0
        while (pq.isNotEmpty()) {//큐가 비어있지 않다면
            //가장 최단 거리가 짧은 노드에 대한 정보 꺼내기
            val node = pq.poll()
            val dist = node.distance//현재 노드까지의 비용
            val now = node.index//현재 노드
            //현재 노드가 이미 처리된 적이 있는 노드라면 무시
            if (d[now] < dist) continue
            //현재 노드와 연결된 다른 인접한 노드들을 확인
            for (i in graph[now]) {
                val cost = d[now] + i.distance
                //현재 노드를 거쳐서, 다른 노드로 이동하는 거리가 더 짧은 경우
                if (cost < d[i.index]) {
                    d[i.index] = cost
                    pq.offer(Node10(i.index, cost))
                }
            }
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        n = sc.nextInt()
        m = sc.nextInt()
        //그래프 초기화
        for (i in 0..n)
            graph.add(ArrayList())
        //모든 간선 정보를 입력받기
        for (i in 0 until m) {
            val a = sc.nextInt()
            val b = sc.nextInt()
            //a번 노드에서 b번 노드로 가는 비용이 1라는 의미(양방향)
            graph[a].add(Node10(b, 1))
            graph[b].add(Node10(a, 1))
        }
        //최단 거리 테이블을 모두 무한으로 초기화
        d.fill(INF)
        //다익스트라 알고리즘을 수행
        dijkstra(start)
        //가장 최단 거리가 먼 노드 번호(동빈이가 숨은 헛간의 번호)
        var maxNode = 0
        //도달할 수 있는 노드 중에서, 가장 최단 거리가 먼 노드와의 최단 거리
        var maxDistance = 0
        //가장 최단 거리가 먼 노드와의 최단 거리와 동일한 최단 거리를 가지는 노드들의 리스트
        val result = ArrayList<Int>()
        for (i in 1..n) {
            if (maxDistance < d[i]) {
                maxNode = i
                maxDistance = d[i]
                result.clear()
                result.add(maxNode)
            } else if (maxDistance == d[i]) result.add(i)
        }
        println("$maxNode $maxDistance ${result.size}")
    }
}