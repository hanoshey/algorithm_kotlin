import java.util.Scanner
import kotlin.math.max

object Pack162 {
    var n = 0
    var dp = Array(500) { IntArray(500) }

    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        n = sc.nextInt()
        for (i in 0 until n)
            for (j in 0 until i + 1)
                dp[i][j] = sc.nextInt()
        //다이나믹 프로그래밍으로 2번째 줄부터 내려가면서 확인
        for (i in 1 until n)
            for (j in 0..i) {
                //왼쪽 위에서 내려오는 경우
                val upLeft = if (j == 0) 0 else dp[i - 1][j - 1]
                //바로 위에서 내려오는 경우
                val up = if (j == i) 0 else dp[i - 1][j]
                //최대 합을 저장
                dp[i][j] = dp[i][j] + max(upLeft, up)
            }
        var result = 0
        for (i in 0 until n)
            result = max(result, dp[n - 1][i])
        println(result)
    }
}