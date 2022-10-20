package Chapter10

import java.util.Scanner

data class Edge2(val distance: Int, val nodeA: Int, val nodeB: Int) : Comparable<Edge2> {
    override fun compareTo(other: Edge2): Int {
        if (distance < other.distance) return -1
        return 1
    }
}

object Pack108 {
    //노드의 개수 V와 간선(Union연산)의 개수 E
    var v = 0
    var e = 0

    //모든 간선을 담을 리스트와, 최종 비용을 담을 변수
    val parent = IntArray(100001)
    val edges = ArrayList<Edge2>()
    var result = 0

    //특정 원소가 속한 집합을 찾기
    private fun findParent(x: Int): Int {
        if (x == parent[x]) return x
        return findParent(parent[x]).also { parent[x] = it }
    }

    private fun unionParent(a: Int, b: Int) {
        val a = findParent(a)
        val b = findParent(b)
        if (a < b) parent[b] = a else parent[a] = b
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        v = sc.nextInt()
        e = sc.nextInt()
        //부모 테이블상에서, 자기 자신으로 초기화
        for (i in 1..v) parent[i] = i
        //모든 간선에 대한 정보를 입력 받기
        for (i in 0 until e) {
            val a = sc.nextInt()
            val b = sc.nextInt()
            val cost = sc.nextInt()
            //비용순으로 정렬하기 위해 튜플의 첫번째 요소를 비용으로 설정
            edges.add(Edge2(cost, a, b))
        }
        //간선을 비용순으로 정렬
        edges.sort()
        var last = 0//최소 신장 트리에 포함되는 간선 중에서 가장 비용이 큰 간선
        //간선을 하나씩 확인하며
        for (i in edges.indices) {
            val cost = edges[i].distance
            val a = edges[i].nodeA
            val b = edges[i].nodeB
            //사이클이 발생하지 않는 경우에만 집합에 포함
            if (findParent(a) != findParent(b)) {
                unionParent(a, b)
                result += cost
                last = cost
            }
        }
        println(result - last)
    }
}