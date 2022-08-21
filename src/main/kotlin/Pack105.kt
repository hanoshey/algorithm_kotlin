import java.util.*
import kotlin.collections.ArrayList

data class Edge(val distance: Int, val nodeA: Int, val nodeB: Int) : Comparable<Edge> {
    override fun compareTo(other: Edge): Int {
        if (distance < other.distance) return -1
        return 1
    }

}

object Pack105 {
    //노드의 개수 V와 간선(Union연산)의 개수 E
    //노드의 개수는 최대 100,000 가정
    var v = 0
    var e = 0
    val parent = IntArray(100001)

    //모든 간선을 담을 리스트와, 최종 비용을 담을 변수
    val edges = ArrayList<Edge>()
    var result = 0

    //특정 원소가 속한 집합을 찾기
    private fun findParent(x: Int): Int {
        if (x == parent[x]) return x
        return findParent(parent[x]).also { parent[x] = it }
    }

    //두 원소가 속한 집합을 합치기
    private fun unionParent(a: Int, b: Int) {
        val a = findParent(a)
        val b = findParent(b)
        if (a < b) parent[b] = a
        else parent[a] = b
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        v = sc.nextInt()
        e = sc.nextInt()
        for (i in 1..v) parent[i] = i//부모를 자기 자신으로 초기화
        //모든 간선 정보 입력 받기
        for (i in 0 until e) {
            val a = sc.nextInt()
            val b = sc.nextInt()
            val cost = sc.nextInt()
            edges.add(Edge(cost, a, b))
        }
        //간선을 비용순으로 정렬
        edges.sort()
        //간선을 하나씩 확인하며
        for (i in edges.indices) {
            val cost = edges[i].distance
            val a = edges[i].nodeA
            val b = edges[i].nodeB
            //사이클이 발생하지 않는 경우에만 집합에 포함
            if (findParent(a) != findParent(b)) {
                unionParent(a, b)
                result += cost
            }
        }
        println(result)
    }
}