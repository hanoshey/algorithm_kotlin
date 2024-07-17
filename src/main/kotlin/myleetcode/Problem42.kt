package myleetcode

private fun main() {
    println(trapStack(intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)))
    println(trapStack(intArrayOf(4, 2, 0, 3, 2, 5)))
    println(trapTwoPointer(intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)))
    println(trapTwoPointer(intArrayOf(4, 2, 0, 3, 2, 5)))
}

private fun trapTwoPointer(height: IntArray): Int {
    if (height.isEmpty()) return 0
    var volume = 0
    var left = 0
    var right = height.size - 1
    var leftMax = height[left]
    var rightMax = height[right]

    while (left < right) {
//        leftMax = maxOf(height[left], leftMax)
//        rightMax = maxOf(height[right], rightMax)
        leftMax = height[left].coerceAtLeast(leftMax)
        rightMax = height[right].coerceAtLeast(rightMax)

        if (leftMax <= rightMax) {
            volume += leftMax - height[left]
            left++
        } else {
            volume += rightMax - height[right]
            right--
        }
    }
    return volume
}

private fun trapStack(height: IntArray): Int {
    val stack = mutableListOf<Int>()
    var volume = 0
    for (i in height.indices) {
        // 변곡점을 만나는 경우
        while (stack.isNotEmpty() && height[i] > height[stack.last()]) {
            val top = stack.removeAt(stack.size - 1)
            if (stack.isEmpty()) break
            // 이전과의 차이만큼 물 높이 처리
            val distance = i - stack.last() - 1
            val waters = minOf(height[i], height[stack.last()]) - height[top]
            volume += distance * waters
        }
        stack.add(i)
    }
    return volume
}