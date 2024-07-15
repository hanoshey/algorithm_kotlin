package mybaekjoon

import java.util.StringTokenizer

private fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val m = st.nextToken().toInt()
    val n = st.nextToken().toInt()
    println(m*n-1)
}