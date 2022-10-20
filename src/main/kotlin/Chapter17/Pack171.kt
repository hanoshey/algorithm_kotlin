package Chapter17

import java.util.Scanner
import kotlin.math.min

object Pack171 {
    val INF = 1e9.toInt()

    //노드의 개수(N), 간선의 개수(M)
    var n = 0
    var m = 0

    //2차원 배열(그래프 표현)을 만들기
    //최단 거리 테이블을 모두 무한으로 초기화
    val graph = Array(101) { IntArray(101) { INF } }

    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        n = sc.nextInt()
        m = sc.nextInt()
        //자기 자신에서 자기 자신으로 가는 비용은 0으로 초기화
        for (a in 1..n)
            for (b in 1..n)
                if (a == b) graph[a][b] = 0
        //각 간선에 대한 정보를 입력 받아, 그 값으로 초기화
        for (i in 0 until m) {
            //A에서 B로 가는 비용은 C라고 설정
            val a = sc.nextInt()
            val b = sc.nextInt()
            val c = sc.nextInt()
            if (c < graph[a][b]) graph[a][b] = c
        }
        //점화식에 따라 플로이드 워셜 알고리즘을 수행
        for (k in 1..n)
            for (a in 1..n)
                for (b in 1..n)
                    graph[a][b] = min(graph[a][b], graph[a][k] + graph[k][b])
        //수행된 결과를 출력
        for (a in 1..n) {
            for (b in 1..n) {
                //도달할 수 없는 경우, 무한(INFINITY)이라고 출력
                if (graph[a][b] == INF) print("0 ")
                //도달할 수 있는 경우 거리를 출력
                else print("${graph[a][b]} ")
            }
            println()
        }
    }
}