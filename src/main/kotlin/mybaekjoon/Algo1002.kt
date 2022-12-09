package mybaekjoon

import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.sqrt

fun main() = with(System.`in`.bufferedReader()) {
    val repeat = readLine().toInt()
    val arr = Array(repeat) { IntArray(6) { 0 } }
    for (i in 0 until repeat)
        arr[i] = readLine().split(" ").map { it.toInt() }.toIntArray()
    for (i in 0 until repeat) {
        val x1 = arr[i][0]
        val y1 = arr[i][1]
        val r1 = arr[i][2]
        val x2 = arr[i][3]
        val y2 = arr[i][4]
        val r2 = arr[i][5]
        val d = sqrt(((x2 - x1).toDouble()).pow(2) + ((y2 - y1).toDouble()).pow(2))
        if (x1 == x2 && y1 == y2 && r1 == r2)
            println(-1)
        else if (d > r1 + r2 || d < abs(r1 - r2))
            println(0)
        else if (d == (r1 + r2).toDouble() || d == abs(r1 - r2).toDouble())
            println(1)
        else
            println(2)
    }
}
// 두 원의 교점의 개수를 구하는 문제
// 두 원의 중심 사이의 거리 d와 두 원의 반지름의 합 r1+r2, 두 원의 반지름의 차의 절대값 abs(r1-r2)를 비교하여 교점의 개수를 구한다.
// d > r1+r2 : 두 원이 서로 다른 두 점에서 만난다.
// d < abs(r1-r2) : 두 원이 서로 내부에 있거나 외부에 있어 만나지 않는다.
// d == r1+r2 : 두 원이 외접한다.
// d == abs(r1-r2) : 두 원이 내접한다.
// d < r1+r2 && d > abs(r1-r2) : 두 원이 서로 다른 두 점에서 만난다.
// d == 0 && r1 == r2 : 두 원이 동심원이고 반지름이 같다.
// d == 0 && r1 != r2 : 두 원이 동심원이지만 반지름이 다르다.
// d != 0 && r1 == r2 : 두 원이 일치한다.
// d != 0 && r1 != r2 : 두 원이 서로 다른 두 점에서 만난다.