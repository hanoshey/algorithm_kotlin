package Chapter18

import java.util.*
import kotlin.collections.ArrayList

object Pack185 {
    var testCase = 0
    var n = 0
    var m = 0

    //모든 노드에 대한 진입차수는 0으로 초기화
    val indegree = IntArray(501)

    //각 노드에 연결된 간선 정보를 담기 위한 배열 초기화
    val graph = Array(501) { BooleanArray(501) }

    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        testCase = sc.nextInt()
        for (tc in 0 until testCase) {
            indegree.fill(0)
            for (i in 0 until 501)
                graph[i].fill(false)
            n = sc.nextInt()
            //작년 순위 정보 입력
            val arrayList = ArrayList<Int>()
            for (i in 0 until n) {
                val x = sc.nextInt()
                arrayList.add(x)
            }
            //방향 그래프의 간선 정보 초기화
            for (i in 0 until n)
                for (j in i + 1 until n) {
                    graph[arrayList[i]][arrayList[j]] = true
                    indegree[arrayList[j]] += 1
                }
            //올해 변경된 순위 정보 입력
            m = sc.nextInt()
            for (i in 0 until m) {
                val a = sc.nextInt()
                val b = sc.nextInt()
                //간선 방향 뒤집기
                if (graph[a][b]) {
                    graph[a][b] = false
                    graph[b][a] = true
                    indegree[a] += 1
                    indegree[b] -= 1
                } else {
                    graph[a][b] = true
                    graph[b][a] = false
                    indegree[a] -= 1
                    indegree[b] += 1
                }
            }
            //위상 정렬 시작
            val result = ArrayList<Int>()
            val q: Queue<Int> = LinkedList()
            //처음 시작할 때는 진입차수가 0인 노드를 큐에 삽입
            for (i in 1..n)
                if (indegree[i] == 0)
                    q.offer(i)
            var certain = true //위상 정렬 결과가 오직 하나인지의 여부
            var cycle = false //그래프 내 사이클이 존재하는지 여부
            //정확히 노드의 개수만큼 반복
            for (i in 0 until n) {
                //큐가 비어 있다면 사이클이 발생했다는 의미
                if (q.size == 0) {
                    cycle = true
                    break
                }
                //큐의 원소가 2개 이상이라면 가능한 정렬 결과가 여러 개라는 의미
                if (q.size >= 2) {
                    certain = false
                    break
                }
                //큐에서 원소 꺼내기
                val now = q.poll()
                result.add(now)
                //해당 원소와 연결된 노드들의 진입차수에서 1 빼기
                for (j in 1..n)
                    if (graph[now][j]) {
                        indegree[j] -= 1
                        //새롭게 진입차수가 0이 되는 노드를 큐에 삽입
                        if (indegree[j] == 0)
                            q.offer(j)
                    }
            }
            //사이클이 발생하는 경우(일관성이 없는 경우)
            if (cycle) println("IMPOSSIBLE")
            //위상 정렬 결과가 여러 개인 경우
            else if (!certain) println("?")
            //위상 정렬을 수행한 결과 출력
            else {
                for (i in result)
                    print("$i ")
                println()
            }
        }
    }
}