package mybaekjoon

import kotlin.math.hypot
import kotlin.math.min

object Algo1007second {
    private var result = 0.0
    private lateinit var isChecked: BooleanArray
    private lateinit var coordinates: Array<IntArray>

    @JvmStatic
    fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
        repeat(readLine().toInt()) {
            val n = readLine().toInt()
            result = Double.MAX_VALUE
            isChecked = BooleanArray(n)
            coordinates = Array(n) { IntArray(2) }
            for (j in 0 until n) {
                val temp = readLine().split(" ").map { it.toInt() }
                coordinates[j][0] = temp[0]
                coordinates[j][1] = temp[1]
            }
            combination(0, n / 2)
            println(result)
        }
        close()
    }

    private fun combination(index: Int, count: Int) {
        if (count == 0)
            result = min(result, vector)
        else
            for (i in index until coordinates.size) {
                isChecked[i] = true
                combination(i + 1, count - 1)
                isChecked[i] = false
            }
    }

    private val vector: Double
        get() {
            var x = 0
            var y = 0
            for (i in coordinates.indices) {
                if (isChecked[i]) {
                    x += coordinates[i][0]
                    y += coordinates[i][1]
                } else {
                    x -= coordinates[i][0]
                    y -= coordinates[i][1]
                }
            }
            return hypot(x.toDouble(), y.toDouble())
        }
}