import java.util.*

object Pack32 {
    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)

        // N, M, K를 공백을 기준으로 구분하여 입력 받기
        val n = sc.nextInt()
        val m = sc.nextInt()
        val k = sc.nextInt()

        // N개의 수를 공백을 기준으로 구분하여 입력 받기
        val arr = IntArray(n)
        for (i in arr.indices) {
            arr[i] = sc.nextInt()
        }
        arr.sort()// 입력 받은 수들 정렬하기
        val first = arr[n - 1] // 가장 큰 수
        val second = arr[n - 2] // 두 번째로 큰 수

        // 가장 큰 수가 더해지는 횟수 계산
        var cnt = m / (k + 1) * k
        cnt += m % (k + 1)
        var result = 0
        result += cnt * first // 가장 큰 수 더하기
        result += (m - cnt) * second // 두 번째로 큰 수 더하기
        println(result)
    }
}