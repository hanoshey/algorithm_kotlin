package mybaekjoon

import java.util.*

private val dp = Array(30) { IntArray(30) { 0 } }
private fun main() = with(System.`in`.bufferedReader()) {
    for (i in 0 until 30) {
        dp[i][i] = 1
        dp[i][0] = 1
    }
    for (i in 2 until 30) {
        for (j in 1 until 30) {
            dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j]
        }
    }
    val n = readLine().toInt()
    var st: StringTokenizer
    val sb = StringBuilder()
    repeat(n) {
        st = StringTokenizer(readLine())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        sb.append(dp[b][a]).append('\n')
    }
    println(sb)
}