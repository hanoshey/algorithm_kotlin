import java.util.*

object Pack181 {
    //여행지의 개수와 여행 계획에 속한 여행지의 개수
    var n = 0
    var m = 0
    val parent = IntArray(501)//부모 테이블 초기화

    //특정 원소가 속한 집합을 찾기
    fun findParent(x: Int): Int {
        //루트 노드가 아니라면, 루트 노드를 찾을 때까지 재귀적으로 호출
        return if (parent[x] != x) findParent(parent[x]) else x
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
        //Union 연산을 각각 수행
        for (i in 0 until n)
            for (j in 0 until n) {
                val x = sc.nextInt()
                //연결된 경우 합집합(Union) 연산 수행
                if (x == 1) unionParent(i + 1, j + 1)
            }
        //여행 계획 입력받기
        val plan = ArrayList<Int>()
        for (i in 0 until m) plan.add(sc.nextInt())
        var result = true
        //여행 계획에 속하는 모든 노드의 루트가 동일한지 확인
        for (i in 0 until m - 1)
            if (findParent(plan[i]) != findParent(plan[i + 1]))
                result = false
        //여행 계획에 속하는 모든 노드가 서로 연결되어 있는지(루트가 동일한지) 확인
        if (result) println("YES") else println("NO")
    }
}