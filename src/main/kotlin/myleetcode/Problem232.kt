package myleetcode

private class MyQueue() {
    private val input = mutableListOf<Int>()
    private val output = mutableListOf<Int>()

    fun push(x: Int) {
        input.add(x)
    }

    fun pop(): Int {
        peek()
        return output.removeAt(output.size - 1)
    }

    fun peek(): Int {
        if (output.isEmpty()) {
            while (input.isNotEmpty()) {
                output.add(input.removeAt(input.size - 1))
            }
        }
        return output.last()

    }

    fun empty(): Boolean {
        return input.isEmpty() && output.isEmpty()
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * var obj = MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */