package Chapter10

import java.util.Scanner

object Pack103 {
    //노드의 개수 V와 간선(Union)의 개수 E
    //노드의 개수는 최대 100,000개라고 가정
    var v = 0
    var e = 0
    val parent = IntArray(100001)
    private fun findParent(x: Int): Int {
        //루트 노드가 아니라면 찾을 때까지 재귀적으로 호출
        if (x == parent[x]) return x
        return findParent(parent[x]).also { parent[x] = it }
    }

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
        for (i in 1..v) parent[i] = i
        //Union 연산 각각 수행
        for (i in 0 until e) {
            val a = sc.nextInt()
            val b = sc.nextInt()
            unionParent(a, b)
        }
        print("각 원소가 속한 집합: ")
        for (i in 1..v) print("${findParent(i)} ")
        println()
        print("부모 테이블: ")
        for (i in 1..v) print("${parent[i]} ")
        println()
    }
}