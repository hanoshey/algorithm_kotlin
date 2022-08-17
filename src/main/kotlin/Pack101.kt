import java.util.*

object Pack101 {
    var v = 0
    var e = 0
    private val parent = IntArray(100001)

    //특정 원소가 속한 집합을 찾기
    private fun findParent(x: Int): Int {
        //루트 노드가 아니라면, 루트 노드를 찾을 때까지 재귀적으로 호출
        if (x == parent[x]) return x
        return findParent(parent[x])
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
        //부모 테이블상에서, 부모를 자기 자신으로 초기화
        for (i in 1..v) parent[i] = i
        //Union연산을 각각 수행
        for (i in 0 until e) {
            val a = sc.nextInt()
            val b = sc.nextInt()
            unionParent(a, b)
        }
        print("각 원소가 속한 집합: ")
        for (i in 1..v) print("${findParent(i)} ")
        println()
        //부모 테이블 내용 출력하기
        print("부모 테이블 : ")
        for (i in 1..v) print("${parent[i]} ")
        println()
    }
}