package Chapter10

import java.util.Scanner

object Pack104 {
    //노드의 개수 V와 간선(Union연산)의 개수(E)
    //노드의 개수는 최대 100,000개라고 가정
    var v = 0
    var e = 0
    val parent = IntArray(100001)//부모 테이블 초기화하기

    //특정 원소가 속한 집합을 찾기
    private fun findParent(x: Int): Int {
        //루트 노드가 아니라면 루트 노드를 찾을 때까지 재귀적으로 호출
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
        //부모 테이블상에서, 부모를 자기 자신으로 초기화
        for (i in 1..v) parent[i] = i
        var cycle = false
        for (i in 0 until e) {
            val a = sc.nextInt()
            val b = sc.nextInt()
            //사이클이 발생할 경우 종료
            if (findParent(a) == findParent(b)) {
                cycle = true
                break
            } else unionParent(a, b)
        }
        if (cycle) println("사이클이 발생했습니다.")
        else println("사이클이 발생하지 않았습니다.")
    }
}