package myleetcode

import java.util.*

private fun main() {
    println(topKFrequent(intArrayOf(1, 1, 1, 2, 2, 3), 2).toList())
    println(topKFrequent(intArrayOf(1), 1).toList())
    println(topKFrequentPy(intArrayOf(1, 1, 1, 2, 2, 3), 2).toList())
    println(topKFrequentPy(intArrayOf(1), 1).toList())
}

private fun topKFrequent(nums: IntArray, k: Int): IntArray {
    val freqs = nums.toList().groupingBy { it }.eachCount()
    val freqsHeap = PriorityQueue<Pair<Int, Int>>(compareBy { -it.first })
    for ((num, count) in freqs) {
        freqsHeap.add(Pair(count, num))
    }
    val topK = IntArray(k)
    for (i in 0 until k) {
        topK[i] = freqsHeap.poll().second
    }
    return topK
}

private fun topKFrequentPy(nums: IntArray, k: Int): IntArray {
    val frequencyMap = nums.toList().groupingBy { it }.eachCount()
    return frequencyMap.entries.sortedByDescending { it.value }
        .take(k).map { it.key }.toIntArray()
}