package myleetcode

private fun main() {
    println(threeSumBruteForce(intArrayOf(-1, 0, 1, 2, -1, -4)))
    println(threeSumTwoPoints(intArrayOf(-1, 0, 1, 2, -1, -4)))
}

private fun threeSumBruteForce(nums: IntArray): List<List<Int>> {
    val results = mutableListOf<List<Int>>()
    nums.sort()
    for (i in 0 until nums.size - 2) {
        if (i > 0 && nums[i] == nums[i - 1]) continue
        for (j in i + 1 until nums.size - 1) {
            if (j > i + 1 && nums[j] == nums[j - 1]) continue
            for (k in j + 1 until nums.size) {
                if (k > j + 1 && nums[k] == nums[k - 1]) continue
                if (nums[i] + nums[j] + nums[k] == 0) {
                    results.add(listOf(nums[i], nums[j], nums[k]))
                }
            }
        }
    }
    return results
}

private fun threeSumTwoPoints(nums: IntArray): List<List<Int>> {
    val results = mutableListOf<List<Int>>()
    nums.sort()
    for (i in 0 until nums.size - 2) {
        if (i > 0 && nums[i] == nums[i - 1]) continue
        var left = i + 1
        var right = nums.size - 1
        while (left < right) {
            val sum = nums[i] + nums[left] + nums[right]
            when {
                sum < 0 -> left++
                sum > 0 -> right--
                else -> {
                    results.add(listOf(nums[i], nums[left], nums[right]))
                    while (left < right && nums[left] == nums[left + 1]) left++
                    while (left < right && nums[right] == nums[right - 1]) right--
                    left++
                    right--
                }
            }
        }
    }
    return results
}