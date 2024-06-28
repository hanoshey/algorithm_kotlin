package mybaekjoon

import kotlin.math.min

private var n = 0
private var attack = 0
private var e = Array(2) { IntArray(10001) }
private var a = IntArray(10001)
private var b = IntArray(10001)
private var c = IntArray(10001)
private const val INF = 1e9.toInt()

private fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    repeat(readLine().toInt()) {
        var result = INF
        var temp = readLine().split(" ").map { it.toInt() }
        n = temp[0]
        attack = temp[1]
        // 구역별 적 배열
        e = Array(2) { IntArray(n) }
        for (j in 0..1) {
            temp = readLine().split(" ").map { it.toInt() }
            for (k in 0 until n)
                e[j][k] = temp[k]
        }
        a = IntArray(n)
        b = IntArray(n)
        c = IntArray(n + 1)
        a[0] = 1
        b[0] = 1
        c[0] = 0

        solve(0)
        result = min(result, c[n])

        if (n > 1) {
            if (e[0][0] + e[0][n - 1] <= attack && e[1][0] + e[1][n - 1] <= attack) {
                a[1] = 1
                b[1] = 1
                c[1] = 0
                solve(1)
                result = min(result, c[n - 1] + 2)
            }

            if (e[0][0] + e[0][n - 1] <= attack) {
                a[1] = 2
                b[1] = if (e[1][0] + e[1][1] > attack) 2 else 1
                c[1] = 1
                solve(1)
                result = min(result, b[n - 1] + 1)
            }

            if (e[1][0] + e[1][n - 1] <= attack) {
                a[1] = if (e[0][0] + e[0][1] > attack) 2 else 1
                b[1] = 2
                c[1] = 1
                solve(1)
                result = min(result, a[n - 1] + 1)
            }
        }
        println(result)
    }
    close()
}

private fun solve(num: Int) {
    for (i in num until n) {
        c[i + 1] = min(a[i] + 1, b[i] + 1)
        if (e[0][i] + e[1][i] <= attack)
            c[i + 1] = min(c[i + 1], c[i] + 1)
        if (i > 0 && e[0][i - 1] + e[0][i] <= attack && e[1][i - 1] + e[1][i] <= attack)
            c[i + 1] = min(c[i + 1], c[i - 1] + 2)
        if (i < n - 1) {
            a[i + 1] = c[i + 1] + 1
            b[i + 1] = c[i + 1] + 1
            if (e[0][i] + e[0][i + 1] <= attack)
                a[i + 1] = min(a[i + 1], b[i] + 1)
            if (e[1][i] + e[1][i + 1] <= attack)
                b[i + 1] = min(b[i + 1], a[i] + 1)
        }
    }
}