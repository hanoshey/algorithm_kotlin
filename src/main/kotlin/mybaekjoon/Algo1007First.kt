package mybaekjoon

import java.util.*
import kotlin.math.hypot
import kotlin.math.min

private var n = 0
private var min = 0.0
private lateinit var vectorArray: Array<Vector>
private fun main() = with(System.`in`.bufferedReader()) {
    var st: StringTokenizer
    repeat(readLine().toInt()) {
        min = Double.MAX_VALUE
        n = readLine().toInt()
        vectorArray = Array(n) {
            st = StringTokenizer(readLine())
            Vector(
                st.nextToken().toInt(),
                st.nextToken().toInt()
            )
        }
        val vector = vectorArray.fold(Vector()) { acc, vector -> acc + vector }
        solve(vector.x, vector.y, n / 2, 0)
        println(min)
    }
}

private fun solve(x: Int, y: Int, index: Int, count: Int) {
    if (index + count > n) return
    if (index == 0) {
        min = min(min, hypot(x.toDouble(), y.toDouble()))
        return
    }
    solve(x, y, index, count + 1)
    solve(
        x - 2 * vectorArray[count].x,
        y - 2 * vectorArray[count].y,
        index - 1, count + 1
    )
}

private class Vector(var x: Int = 0, var y: Int = 0) {
    operator fun plus(v: Vector) = Vector(x + v.x, y + v.y)
}
