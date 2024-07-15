package myleetcode

import kotlin.math.max
import kotlin.math.min

private fun main() {
    println(maxProfitBF(intArrayOf(7, 1, 5, 3, 6, 4)))
    println(maxProfitBF(intArrayOf(7, 6, 4, 3, 1)))
}

private fun maxProfitBF(prices: IntArray): Int {
    var maxPrice = 0
    for ((index, price) in prices.withIndex())
        for (j in index until prices.size)
            maxPrice = max(prices[j] - price, maxPrice)
    return maxPrice
}

private fun maxProfit(prices: IntArray): Int {
    var profit = 0
    var minPrice = Int.MAX_VALUE
    // 최솟값과 최댓값을 계속 갱신
//    prices.forEach {
//        minPrice = min(minPrice, it)
//        profit = max(profit, it - minPrice)
//    }
    for (price in prices) {
        minPrice = min(minPrice, price)
        profit = max(profit, price - minPrice)
    }
    return profit
}