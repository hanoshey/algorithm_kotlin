package Chapter13

import java.util.*
import kotlin.collections.ArrayList

object Pack131 {
    //도시의 개수, 도로의 개수, 거리 정보, 출발 도시 번호
    var n = 0
    var m = 0
    var k = 0
    var x = 0
    val graph = ArrayList<ArrayList<Int>>()

    //모든 도시에 대한 최단 거리 초기화
    val d = IntArray(300001)

    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        n = sc.nextInt()
        m = sc.nextInt()
        k = sc.nextInt()
        x = sc.nextInt()
        // 그래프 및 최단 거리 테이블 초기화
        for (i in 0 ..n) {
            graph.add(ArrayList())
            d[i] = -1
        }
        // 모든 도로 정보 입력 받기
        for (i in 0 until m) {
            val a = sc.nextInt()
            val b = sc.nextInt()
            graph[a].add(b)
        }
        //출발 도시까지의 거리는 0으로 설정
        d[x] = 0
        //너비 우선 탐색(BFS) 수행
        val q: Queue<Int> = LinkedList()
        q.offer(x)
        while (!q.isEmpty()) {
            val now = q.poll()
            //현재 도시에서 이동할 수 있는 모든 도시를 확인
            for (i in 0 until graph[now].size) {
                val nextNode = graph[now][i]
                //아직 방문하지 않은 도시라면
                if (d[nextNode] == -1) {
                    //최단 거리 갱신
                    d[nextNode] = d[now] + 1
                    q.offer(nextNode)
                }
            }
        }
        //최단 거리가 K인 모든 도시의 번호를 오름차순으로 출력
        var check = false
        for (i in 1..n) {
            if (d[i] == k) {
                println(i)
                check = true
            }
        }
        //만약 최단 거리가 K인 도시가 없다면, -1 출력
        if (!check) println(-1)
    }
}