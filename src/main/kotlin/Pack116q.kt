import java.util.*
import kotlin.collections.ArrayList

data class Food(val time: Int, val index: Int) : Comparable<Food> {
    override fun compareTo(other: Food): Int {
        return Integer.compare(this.time,other.time)
    }
}

class Solution {
    fun solution(food_times: IntArray, k: Long): Int {
        //전체 음식을 먹는 시간보다 k가 크거나 같다면 -1
        var summary = 0L
        for (i in 0 until food_times.size)
            summary += food_times[i]
        if (summary <= k) return -1
        //시간이 작은 음식부터 빼야 하므로 우선순위 큐 이용
        val pq = PriorityQueue<Food>()
        for (i in 0 until food_times.size)
        //(음식 시간, 음식 번호) 형태로 우선순위 큐에 삽입
            pq.offer(Food(food_times[i], i + 1))
        summary = 0//먹기 위해 사용한 시간
        var previous = 0L//직전에 다 먹은 음식 시간
        var length = food_times.size//남은 음식의 개수
        //summary+(현재의 음식 시간- 이전 음식 시간)*현재 음식 개수와 k 비교
        while (summary + ((pq.peek().time - previous)) * length <= k) {
            val now = pq.poll().time
            summary += ((now + previous) * length).toInt()
            length -= 1//다 먹은 음식 제외
            previous = now.toLong()//이전 음식 시간 재설정
        }
        //남은 음식 중에서 몇 번째 음식인지 확인하여 출력
        val result = ArrayList<Food>()
        while (!pq.isEmpty())
            result.add(pq.poll())
        //음식의 번호 기준으로 정렬
        result.sortWith { a, b -> a.index.compareTo(b.index) }
        return result[((k - summary) % length).toInt()].index
    }
}