package myleetcode

private class MyCircularQueue(k: Int) {
    private val q = arrayOfNulls<Int>(k)
    private val maxlen = k
    private var p1 = 0
    private var p2 = 0

    fun enQueue(value: Int): Boolean {
        return if (q[p2] == null) {
            q[p2] = value
            p2 = (p2 + 1) % maxlen
            true
        } else {
            false
        }
    }

    fun deQueue(): Boolean {
        return if (q[p1] == null) {
            false
        } else {
            q[p1] = null
            p1 = (p1 + 1) % maxlen
            true
        }
    }

    fun Front(): Int {
        return if (q[p1] == null) -1 else q[p1]!!
    }

    fun Rear(): Int {
        return if (q[(p2 - 1 + maxlen) % maxlen] == null) -1 else q[(p2 - 1 + maxlen) % maxlen]!!
    }

    fun isEmpty(): Boolean {
        return p1 == p2 && q[p1] == null
    }

    fun isFull(): Boolean {
        return p1 == p2 && q[p1] != null
    }
}
