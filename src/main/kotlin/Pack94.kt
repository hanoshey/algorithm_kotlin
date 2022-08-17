import java.util.*
import kotlin.math.min

object Pack94 {
    val INF = 1e9.toInt()

    //노드의 개수 N, 간선의 개수 M, 거쳐갈 노드 X, 최종 목적지 노드 K
    var n = 0
    var m = 0
    var x = 0
    var k = 0
    val graph = Array(101) { IntArray(101) }

    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        n = sc.nextInt()
        m = sc.nextInt()
        for (i in 0 until 101)
            graph[i].fill(INF)
        //자기 자신에서 자기 자신으로 가는 비용은 0으로 초기화
        for (a in 1..n)
            for (b in 1..n)
                if (a == b) graph[a][b] = 0
        //각 간선에 대한 정보를 입력 받아, 그 값으로 초기화
        for (i in 0 until m) {
            //A와 B가 서로에게 가는 비용은 1이라고 설정
            val a = sc.nextInt()
            val b = sc.nextInt()
            graph[a][b] = 1
            graph[b][a] = 1
        }
        x = sc.nextInt()
        k = sc.nextInt()
        for (k in 1..n)
            for (a in 1..n)
                for (b in 1..n)
                    graph[a][b] = min(graph[a][b], graph[a][k] + graph[k][b])
        //수행된 결과 출력
        val distance = graph[1][k] + graph[k][x]
        //도달할 수 없는 경우, -1 출력
        if (distance >= INF) println(-1)
        else println(distance)
    }
}