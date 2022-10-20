package Chapter18

import java.util.*
import kotlin.collections.ArrayList

class Edge4(val distance: Int, val nodeA: Int, val nodeB: Int) : Comparable<Edge4> {
    override fun compareTo(other: Edge4): Int {
        if (distance < other.distance) return -1
        return 1
    }
}

class Position4(val x: Int, val y: Int) : Comparable<Position4> {
    override fun compareTo(other: Position4): Int {
        if (x == other.x) return y.compareTo(other.y)
        return x.compareTo(other.x)
    }
}

object Pack184 {
    //노드의 개수
    var n = 0
    val parent = IntArray(100001)//부모 테이블 초기화

    //모든 간선을 담을 리스트와, 최종 비용을 담을 변수
    val edges = ArrayList<Edge4>()
    var result = 0

    //특정 원소가 속한 집합을 찾기
    fun findParent(x: Int): Int {
        //루트 노드가 아니라면, 루트 노드를 찾을 때까지 재귀적으로 호출
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
        //부모 테이블상에서, 부모를 자기 자신으로 초기화
        for (i in 1..n) parent[i] = i
        val x = ArrayList<Position4>()
        val y = ArrayList<Position4>()
        val z = ArrayList<Position4>()
        //모든 노드에 대한 좌표 값 입력받기
        for (i in 1..n) {
            val a = sc.nextInt()
            val b = sc.nextInt()
            val c = sc.nextInt()
            x.add(Position4(a, i))
            y.add(Position4(b, i))
            z.add(Position4(c, i))
        }
        x.sort()
        y.sort()
        z.sort()
        //인접한 노드들로부터 간선 정보를 추출하여 처리
        for (i in 0 until n - 1) {
            edges.add(Edge4(x[i + 1].x - x[i].x, x[i].y, x[i + 1].y))
            edges.add(Edge4(y[i + 1].x - y[i].x, y[i].y, y[i + 1].y))
            edges.add(Edge4(z[i + 1].x - z[i].x, z[i].y, z[i + 1].y))
        }
        //간선을 비용순으로 정렬
        edges.sort()
        //간선을 하나씩 확인하며
        for (edge in edges) {
            val cost = edge.distance
            val a = edge.nodeA
            val b = edge.nodeB
            //사이클이 발생하지 않는 경우에만 집합에 포함
            if (findParent(a) != findParent(b)) {
                unionParent(a, b)
                result += cost
            }
        }
        println(result)
    }
}