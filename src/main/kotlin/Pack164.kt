import java.util.Scanner
import kotlin.math.max

object Pack164 {
    var n = 0
    val v = ArrayList<Int>()
    val dp = IntArray(2000)

    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        n = sc.nextInt()
        for (i in 0 until n) v.add(sc.nextInt())
        //순서를 뒤집어 '최장 증가 부분 수열' 문제로 변환
        v.reverse()
        //다이나믹 프로그래밍을 위한 1차원 DP 테이블 초기화
        for (i in 0 until n) dp[i] = 1
        //가장 긴 증가하는 부분 수열(LIS) 알고리즘 수행
        for (i in 0 until n)
            for (j in 0 until i)
                if (v[j] < v[i]) dp[i] = max(dp[i], dp[j] + 1)
        //열외해야 하는 병사의 최소 수를 출력
        var maxValue = 0
        for (i in 0 until n) maxValue = max(maxValue, dp[i])
        println(n - maxValue)
    }
}