package Chapter9

import java.util.*
import kotlin.math.min

object Pack93 {
    val INF = 1e9.toInt()
    var n = 0
    var m = 0
    var graph = Array(501) { IntArray(501) }

    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        n = sc.nextInt()
        m = sc.nextInt()
        //최단 거리 테이블 무한으로 초기화
        for (i in 0 until 501)
            graph[i].fill(INF)
        //자기 자신에서 자기 자신으로 가는 비용은 0
        for (a in 1..n)
            for (b in 1..n)
                if (a == b) graph[a][b] = 0
        for (i in 0 until m) {
            val a = sc.nextInt()
            val b = sc.nextInt()
            val c = sc.nextInt()
            graph[a][b] = c
        }
        // 점화식에 따라 플로이드 워셜 알고리즘 수행
        for (k in 1..n)
            for (a in 1..n)
                for (b in 1..n)
                    graph[a][b] = min(graph[a][b], graph[a][k] + graph[k][b])
        //수행된 결과물 출력
        for (a in 1..n) {
            for (b in 1..n) {
                if (graph[a][b] == INF) print("INFINITY ")
                else print("${graph[a][b]} ")
            }
            println()
        }
    }
}