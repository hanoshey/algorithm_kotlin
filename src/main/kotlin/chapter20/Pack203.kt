package chapter20

object Pack203 {
    val n = 5//데이터의 개수 N
    val m = 5//찾고자 하는 부분합 M
    val arr = intArrayOf(1, 2, 3, 2, 5)//전체 수열

    @JvmStatic
    fun main(args: Array<String>) {
        var cnt = 0
        var intervalSum = 0
        var end = 0
        //start를 차례대로 증가시켜 반복
        for (start in 0 until n) {
            //end를 가능한 만큼 이동시키기
            while (intervalSum < m && end < n) {
                intervalSum += arr[end]
                end += 1
            }
            //부분합이 m일 때 카운트 증가
            if (intervalSum == m) cnt += 1
            intervalSum -= arr[start]
        }
        println(cnt)
    }
}