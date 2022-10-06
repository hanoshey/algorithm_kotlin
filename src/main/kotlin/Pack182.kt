import java.util.Scanner

object Pack182 {
    var g = 0
    var p = 0
    val parent = IntArray(100001)//부모 테이블 초기화

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
        g = sc.nextInt()
        p = sc.nextInt()
        //부모 테이블상에서, 부모를 자기 자신으로 초기화
        for (i in 1..g) parent[i] = i
        var result = 0
        for (i in 0 until p) {
            val x = sc.nextInt()
            val root = findParent(x)//현재 비행기의 탑승구의 루트 확인
            if (root == 0) break//현재 루트가 0이라면, 종료
            unionParent(root, root - 1)//그렇지 않다면 바로 왼쪽의 집합과 합치기
            result += 1
        }
        println(result)
    }
}