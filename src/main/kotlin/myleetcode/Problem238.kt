package myleetcode

private fun main() {
    println(productExcept(intArrayOf(1, 2, 3, 4)).toList())
    println(productExcept(intArrayOf(-1, 1, 0, -3, 3)).toList())
    println(productExcept(intArrayOf(1,2,3,58,74,541,54)).toList())
}

private fun productExceptSelfDivide(nums: IntArray): IntArray {
    val exception = mutableListOf<Int>()
    var initial = 1
    nums.forEach {
        initial *= it.takeUnless { num -> num == 0 } ?: 1
    }
    nums.forEach {
        if (it != 0)
            exception.add(initial / it)
        else exception.add(0)
    }
    return exception.toIntArray()
    // not working at all!
}

private fun productExcept(nums: IntArray): IntArray {
    val out = IntArray(nums.size)
    var p = 1
    for (i in nums.indices) {
        out[i] = p
        p *= nums[i]
//        println(out.toList())
    }
//    println("reverse!")
    p = 1
    for (i in nums.indices.reversed()) {
        out[i] *= p
        p *= nums[i]
//        println(out.toList())
    }
//    println("End!")
    return out
}
