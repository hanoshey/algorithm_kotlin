import java.util.Scanner

object Pack107 {
    //노드의 개수 N과 연산의 개수 M
    var n = 0
    var m = 0
    val parent = IntArray(100001)//부모테이블초기화

    //특정 원소가 속한 집합을 찾기
    private fun findParent(x: Int): Int {
        //루트 노드가 아니라면, 찾을 떼까지 재귀적으로 호출
        if (x == parent[x]) return x
        return findParent(parent[x]).also { parent[x] = it }
    }

    //두 원소가 속한 집합을 합치기
    private fun unionParent(a: Int, b: Int) {
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
        //각 연산을 하나씩 확인
        for (i in 0 until m) {
            val oper = sc.nextInt()
            val a = sc.nextInt()
            val b = sc.nextInt()
            //합집합(union) 연산일 경우
            if (oper == 0) unionParent(a, b)
            //찾기(Find)연산일 경우
            else if (oper == 1) {
                if (findParent(a) == findParent(b)) println("YES")
                else println("NO")
            }
        }
    }
}