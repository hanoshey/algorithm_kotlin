import java.util.*
import kotlin.collections.ArrayList

object Pack106 {
    //노드의 개수V와 간선의 개수 E
    var v = 0
    var e = 0

    //모든 노드에 대한 진입차수는 0으로 초기화
    val indegree = IntArray(100001)

    //각 노드에 연결된 간선 정보를 담기 위한 연결 리스트 초기화
    val graph = ArrayList<ArrayList<Int>>()

    //위상 정렬 함수
    fun topologySort() {
        val result = ArrayList<Int>()//알고리즘 수행 결과를 담을 리스트
        val q: Queue<Int> = LinkedList()//큐 라이브러리 사용
        //처음 시작할 때는 진입차수가 0인 노드를 큐에 삽입
        for (i in 1..v)
            if (indegree[i] == 0) q.offer(i)
        //큐가 빌 때까지 반복
        while (!q.isEmpty()) {
            //큐에서 원소 꺼내기
            val now = q.poll()
            result.add(now)
            //해당 원소와 연결된 노드들의 진입차수에서 1 빼기
            for (i in graph[now].indices) {
                indegree[graph[now][i]] -= 1
                //새롭게 진입차수가 0이 되는 노드를 큐에 삽입
                if (indegree[graph[now][i]] == 0) q.offer(graph[now][i])

            }
        }
        //위상 정렬을 수행한 결과 출력
        for (i in result.indices) print("${result[i]} ")
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        v = sc.nextInt()
        e = sc.nextInt()
        //그래프 초기화
        for (i in 0..v) graph.add(ArrayList())
        //방향 그래프의 모든 간선 정보를 입력 받기
        for (i in 0 until e) {
            val a = sc.nextInt()
            val b = sc.nextInt()
            graph[a].add(b)//정점 A에서 B로 이동 가능
            //진입 차수를 1로 증가
            indegree[b] += 1
        }
        topologySort()
    }
}