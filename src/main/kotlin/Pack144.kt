import java.util.*

object Pack144 {
    var n = 0
    var result = 0

    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        n = sc.nextInt()
        val pq = PriorityQueue<Int>()
        //힙(Heap)에 초기 카드 묶음을 모두 삽입
        for (i in 0 until n) pq.offer(sc.nextInt())
        //힙에 원소가 1개 남을 때까지
        while (pq.size != 1) {
            //가장 작은 2개의 카드 묶음 꺼내기
            val one = pq.poll()
            val two = pq.poll()
            //카드 묶음을 합쳐서 다시 삽입
            val summary = one + two
            result += summary
            pq.offer(summary)
        }
        println(result)
    }
}