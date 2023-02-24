package mybaekjoon

import kotlin.math.hypot
import kotlin.math.min

object Algo1007 {
    const val INF = 1e9

    @JvmStatic
    fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
        val result=ArrayList<Double>()
        repeat(readLine().toInt()) {
            val n = readLine().toInt()
            val coords = arrayListOf<Pair<Int, Int>>()
            var x_total = 0
            var y_total = 0
            repeat(n) {
                val (x, y) = readLine().split(' ').map { it.toInt() }
                x_total += x
                y_total += y
                coords.add(Pair(x, y))
            }
            var res = INF
            val combination = combination(coords, n / 2)
            val combi_halflen = combination.size / 2
            for (sum_coord in combination.toTypedArray().copyOfRange(0, combi_halflen)) {
                var x1_total = 0
                var y1_total = 0
                for (i in sum_coord) {
                    x1_total += i.first
                    y1_total += i.second
                }
                val x2_total = x_total - x1_total
                val y2_total = y_total - y1_total
                res = min(res, hypot(x1_total - x2_total.toDouble(), y1_total - y2_total.toDouble()))
            }
            result.add(res)
        }
        result.forEach{ println(it) }
    }

    private fun combination(coords: ArrayList<Pair<Int, Int>>, n: Int): ArrayList<ArrayList<Pair<Int, Int>>> {
        val result = ArrayList<ArrayList<Pair<Int, Int>>>()
        if (n == 1) {
            for (i in coords)
                result.add(arrayListOf(i))
        } else {
            for (i in 0 until coords.size - n + 1) {
                val temp = coords[i]
                val temp_coords = coords.toTypedArray().copyOfRange(i + 1, coords.size)
                val temp_result = combination(ArrayList(temp_coords.asList()), n - 1)
                for (j in temp_result)
                    j.add(0, temp)
                result.addAll(temp_result)
            }
        }
        return result
    }
}