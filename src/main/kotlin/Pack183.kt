import java.util.Scanner

class Edge3(val distance: Int, val nodeA: Int, val nodeB: Int) : Comparable<Edge3> {
    override fun compareTo(other: Edge3): Int {
        if (distance < other.distance) return -1
        return 1
    }
}

object Pack183 {
    //노드의 개수와 간선의 개수
    var n = 0
    var m = 0
    val parent = IntArray(200001)//부모 테이블 초기화하기

    //모든 간선을 담을 리스트와, 최종 비용을 담을 변수
    val edges = ArrayList<Edge3>()
    var result = 0

    //특정 원소가 속한 집합을 찾기
    fun findParent(x: Int): Int {
        if (parent[x] == x) return x
        return findParent(parent[x]).also { parent[x] = it }
    }

    //두 원소가 속한 집합을 합치기
    fun unionParent(a: Int, b: Int) {
        val a = findParent(a)
        val b = findParent(b)
        if (a < b) parent[b] = a else parent[a] = b
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        n = sc.nextInt()
        m = sc.nextInt()
        //부모 테이블상에서, 부모를 자기 자신으로 초기화
        for (i in 1..n) parent[i] = i
        //모든 간선에 대한 정보를 입력받기
        for (i in 0 until m) {
            val x = sc.nextInt()
            val y = sc.nextInt()
            val z = sc.nextInt()
            edges.add(Edge3(z, x, y))
        }
        //간선을 비용순으로 정렬
        edges.sort()
        var total = 0//전체 가로등 비용
        //간선을 하나씩 확인하며
        for (i in edges) {
            val cost = i.distance
            val a = i.nodeA
            val b = i.nodeB
            //사이클이 발생하지 않는 경우에만 집합에 포함
            if (findParent(a) != findParent(b)) {
                unionParent(a, b)
                result += cost
            }
            total += cost
        }
        println(total - result)
    }
}