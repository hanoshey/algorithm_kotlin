package mybaekjoon

import kotlin.math.hypot

//백준 1004번 어린 왕자
fun isContain(x1: Int, y1: Int, x2: Int, y2: Int, r: Int): Boolean {
    return hypot((x2 - x1).toDouble(), (y2 - y1).toDouble()) < r
}
// 두 점 사이의 거리가 반지름보다 작으면 원 안에 포함된다.
fun main() = with(System.`in`.bufferedReader()) {
    repeat(readLine().toInt()) {
        var through = 0
        val (x1, y1, x2, y2) = readLine().split(" ").map { it.toInt() }
        val n = readLine().toInt()
        for (i in 0 until n) {
            val (cx, cy, r) = readLine().split(" ").map { it.toInt() }
            // 해당 행성이 출발점 혹은 도착점 중 하나만을 포함할 경우
            if (isContain(x1, y1, cx, cy, r) xor isContain(x2, y2, cx, cy, r))
                through++
        }
        println(through)
    }
}