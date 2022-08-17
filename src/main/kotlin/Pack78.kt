import java.util.*

object Pack78 {
    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        //떡의 개수 n 과 요청한 떡의 길이 m
        val n = sc.nextInt()
        val m = sc.nextInt()
        //각 떡의 개별 높이 정보
        val arr = IntArray(n)
        for (i in 0 until n)
            arr[i] = sc.nextInt()
        var start = 0
        var end = 1e9.toInt()
        var result = 0
        while (start <= end) {
            var total = 0L
            val mid = (start + end) / 2
            for (i in 0 until n)
            //잘랐을 때의 떡의 양 계산
                if (arr[i] > mid) total += arr[i] - mid
            if (total < m)//떡의 양이 부족한 경우 더 많이 자르기(왼쪽 탐색)
                end = mid - 1
            else {//떡의 양이 충분할 경우 덜 자르기(오른쪽 탐색)
                result = mid
                start = mid + 1
            }
        }
        println(result)
    }
}