package mybaekjoon

import java.lang.StringBuilder
import java.util.StringTokenizer

private val dp = Array(30) { IntArray(30) { 0 } }
private fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    var st: StringTokenizer
    val sb = StringBuilder()
    repeat(n) {
        st = StringTokenizer(readLine())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        sb.append(combination(b, a)).append('\n')
    }
    println(sb)
}

private fun combination(n: Int, r: Int): Int {
    if (dp[n][r] > 0) return dp[n][r]
    if (n == r || r == 0) {
        dp[n][r] = 1
        return dp[n][r]
    }
    return (combination(n - 1, r - 1) + combination(n - 1, r)).also {
        dp[n][r] = it
    }
}