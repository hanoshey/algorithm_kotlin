package mybaekjoon

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val bw = System.out.bufferedWriter()
    val n = readLine().toInt()
    var st:StringTokenizer
    val resultArray = IntArray(n)
    repeat(n) {
        st = StringTokenizer(readLine())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        resultArray[it] = a.minPow(b)
    }
    resultArray.forEach {
        bw.write("$it\n")
    }
    bw.flush()
    bw.close()
}

private fun Int.minPow(b: Int): Int {
    var result = 1
    if (this % 10 == 0) return 10
    repeat(b) {
        result *= this % 10
        result %= 10
    }
    return result
}