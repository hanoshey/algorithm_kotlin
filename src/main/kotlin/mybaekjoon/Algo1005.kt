package mybaekjoon

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    repeat(readLine().toInt()) {
        val st = StringTokenizer(readLine()," ")
        val (n, k) = st.nextToken().toInt() to st.nextToken().toInt()
        val time = IntArray(n + 1)
        //시간
        val indegree = IntArray(n + 1) { 0 }
        //차원
        val graph = Array(n + 1) { IntArray(n + 1) { 0 } }
        val dp = IntArray(n + 1) { 0 }
        //다이나믹 프로그래밍 배열
        for (i in 1..n)
            time[i] = st.nextToken().toInt()
        for (i in 0 until k) {
            val (a, b) = readLine().split(" ").map { it.toInt() }
            graph[a][b] = 1
            indegree[b]++
        }
        val w = readLine().toInt()
        val q = IntArray(10001)
        var front = 0
        var rear = 0
        for (i in 1..n)
            if (indegree[i] == 0) {
                q[rear++] = i
                dp[i] = time[i]
            }
        while (front != rear) {
            val now = q[front++]
            for (i in 1..n)
                if (graph[now][i] == 1) {
                    indegree[i]--
                    dp[i] = maxOf(dp[i], dp[now] + time[i])
                    if (indegree[i] == 0)
                        q[rear++] = i
                }
        }
        bw.write("${dp[w]}\n")
        bw.flush()
    }
    bw.close()
}