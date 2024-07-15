package myleetcode

private fun main() {
    println(dailyTemperatures(intArrayOf(73, 74, 75, 71, 69, 72, 76, 73)).toList())
    println(dailyTemperatures(intArrayOf(30, 40, 50, 60)).toList())
    println(dailyTemperatures(intArrayOf(30, 60, 90)).toList())
}

private fun dailyTemperatures(temperatures: IntArray): IntArray {
    val answer = IntArray(temperatures.size)
    val stack = mutableListOf<Int>()
    for ((i, cur) in temperatures.withIndex()) {
        //현재 온도가 스택 값보다 높다면 정답 처리
        while (stack.isNotEmpty() && cur > temperatures[stack.last()]) {
            println("executed. $stack")
            val last = stack.removeAt(stack.size - 1)
            println("i: $i, last: $last")
            answer[last] = i - last
            println("end")
        }
        stack.add(i)
    }
    return answer
}