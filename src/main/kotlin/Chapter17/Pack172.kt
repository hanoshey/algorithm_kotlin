package Chapter17

import java.util.*
import kotlin.math.min

object Pack172 {
    val INF=1e9.toInt()
    //노드의 개수(N), 간선의 개수(M)
    var n=0
    var m=0
    //2차원 배열(그래프 표현)을 만들기
    val graph=Array(501){IntArray(501){ INF }}

    @JvmStatic
    fun main(args: Array<String>) {
        val sc= Scanner(System.`in`)
        n =sc.nextInt()
        m =sc.nextInt()
        //자기 자신에서 자기 자신으로 가는 비용은 0으로 초기화
        for(a in 1..n)
            for(b in 1..n)
                if(a==b) graph[a][b]=0
        //각 간선에 대한 정보를 입력 받아, 그 값으로 초기화
        for(i in 0 until m){
            //A에서 B로 가는 비용은 C라고 설정
            val a=sc.nextInt()
            val b=sc.nextInt()
            graph[a][b]=1
        }
        // 점화식에 따라 플로이드 워셜 알고리즘을 수행
        for(k in 1..n)
            for(a in 1..n)
                for(b in 1..n)
                    graph[a][b]=min(graph[a][b], graph[a][k]+ graph[k][b])
        var result=0
        //각 학생을 번호에 따라 한 명씩 확인하며 도달 가능한지 체크
        for(i in 1..n){
            var cnt=0
            for(j in 1..n)
                if(graph[i][j]!= INF || graph[j][i]!= INF) cnt++
            if(cnt== n) result+=1
        }
        println(result)
    }
}