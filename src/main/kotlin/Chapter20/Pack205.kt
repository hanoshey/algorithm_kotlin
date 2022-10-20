package Chapter20

object Pack205 {
    val n = 5//데이터의 개수 N과 데이터 입력받기
    var arr = intArrayOf(10, 20, 30, 40, 50)
    val prefixSum = IntArray(6)

    @JvmStatic
    fun main(args: Array<String>) {
        //접두사 합(Prefix Sum)배열 계산
        var sumValue = 0
        for (i in 0 until n) {
            sumValue += arr[i]
            prefixSum[i + 1] = sumValue
        }
        //구간 합 계산(세 번째 수부터 네 번째 수까지)
        val left = 3
        val right = 4
        println(prefixSum[right] - prefixSum[left - 1])
    }
}