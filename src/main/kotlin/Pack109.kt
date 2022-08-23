import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.max

object Pack109 {
    var v = 0//노드의 개수 V

    //모든 노드에 대한 진입차수는 0으로 초기화
    val indegree = IntArray(501)

    //각 노드에 연결된 간선 정보를 담기 위한 연결 리스트 초기화
    val graph = ArrayList<ArrayList<Int>>()

    //각 강의 시간을 0으로 초기화
    val times = IntArray(501)

    //위상 정렬 함수
    private fun topologySort() {
        val result = IntArray(501)//알고리즘 수행 결과를 담을 배열
        for (i in 1..v) result[i] = times[i]
        val q: Queue<Int> = LinkedList()
        //처음 시작할때는 진입차수가 0인 노드를 큐에 삽입
        for (i in 1..v)
            if (indegree[i] == 0) q.offer(i)
        //큐가 빌 때까지 반복
        while (!q.isEmpty()) {
            //큐에서 원소 꺼내기
            val now = q.poll()
            //해당 원소와 연결된 노드들의 진입차수에서 1 빼기
            for (i in graph[now].indices) {
                result[graph[now][i]] =
                    max(
                        result[graph[now][i]],
                        result[now] + times[graph[now][i]]
                    )
                indegree[graph[now][i]] -= 1
                //새롭게 진입차수가 0이 되는 노드를 큐에 삽입
                if (indegree[graph[now][i]] == 0) q.offer(graph[now][i])
            }
        }
        //위상 정렬을 수행한 결과 출력
        for (i in 1..v) println(result[i])
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        v = sc.nextInt()
        //그래프 초기화
        for (i in 0..v) graph.add(ArrayList())
        //방향 그래프의 모든 간선 정보를 입력받기
        for (i in 1..v) {
            //첫 번째 수는 시간 정보를 담고 있음
            var x = sc.nextInt()
            times[i] = x
            //해당 강의를 듣기 위해 먼저 들어야 하는 강의들의 번호 입력
            while (true) {
                x = sc.nextInt()
                if (x == -1) break
                indegree[i] += 1
                graph[x].add(i)
            }
        }
        topologySort()
    }
}