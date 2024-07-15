package myleetcode


private fun main() {
    println(arrayPairSumAsc(intArrayOf(1, 4, 3, 2)))
    println(arrayPairSumAsc(intArrayOf(6, 2, 6, 5, 2, 1)))
    println(arrayPairSumEvenNum(intArrayOf(1, 4, 3, 2)))
    println(arrayPairSumEvenNum(intArrayOf(6, 2, 6, 5, 2, 1)))
    println(arrayPairSumSimple(intArrayOf(1, 4, 3, 2)))
    println(arrayPairSumSimple(intArrayOf(6, 2, 6, 5, 2, 1)))
}

private fun arrayPairSumAsc(nums: IntArray): Int {
    var sum = 0
    val pair = mutableListOf<Int>()
    nums.sort()
    nums.forEach {
        // 앞에서부터 오름차순으로 페어를 만들어 합 계산
        pair.add(it)
        if (pair.size == 2) {
            sum += pair.min()
            pair.clear()
        }
    }
    return sum
}

private fun arrayPairSumEvenNum(nums: IntArray): Int {
    var sum = 0
    nums.sort()
    for ((index, num) in nums.withIndex()) {
        // 짝수 번째 값의 합 계산
        if (index % 2 == 0) sum += num
    }
    return sum
}

private fun arrayPairSumSimple(nums: IntArray) =
    nums.sorted().filterIndexed { index, _ -> index % 2 == 0 }.sum()

