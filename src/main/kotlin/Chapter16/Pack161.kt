package Chapter16

import java.util.*
import kotlin.math.max

private object Pack161 {
    var testCase = 0
    var n = 0
    var m = 0
    val arr = Array(20) { IntArray(20) }
    val dp = Array(20) { IntArray(20) }

    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        //테스트 케이스 입력
        testCase = sc.nextInt()
        for (tc in 0 until testCase) {
            //금광 정보 입력
            n = sc.nextInt()
            m = sc.nextInt()
            for (i in 0 until n)
                for (j in 0 until m)
                    arr[i][j] = sc.nextInt()
            //다이나믹 프로그래밍 진행을 위한 2차원 DP 테이블 초기화
            for (i in 0 until n)
                for (j in 0 until m)
                    dp[i][j] = arr[i][j]
            //다이나믹 프로그래밍 진행
            for (j in 1 until m)
                for (i in 0 until n) {
                    //왼쪽 위에서 오는 경우
                    val leftUp = if (i == 0) 0
                    else dp[i - 1][j - 1]
                    //왼쪽 아래에서 오는 경우
                    val leftDown = if (i == n - 1) 0
                    else dp[i + 1][j - 1]
                    //왼쪽에서 오는 경우
                    val left = dp[i][j - 1]
                    dp[i][j] = arr[i][j] + maxOf(leftUp, leftDown, left)
                }
            var result = 0
            for (i in 0 until n)
                result = max(result, dp[i][m - 1])
            println(result)
        }
    }
}