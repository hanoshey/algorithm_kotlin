package myleetcode

import java.util.ArrayDeque

private fun main() {

}

private class MyStack {
    private val q: ArrayDeque<Int> = ArrayDeque()

    fun push(x: Int) {
        q.add(x)
        // Reorder elements to maintain the stack order
        for (i in 0 until q.size - 1) {
            q.add(q.remove())
        }
    }

    fun pop(): Int {
        return q.remove()
    }

    fun top(): Int {
        return q.peek()
    }

    fun empty(): Boolean {
        return q.isEmpty()
    }
}

