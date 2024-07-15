package myleetcode


private class MyCircularDeque(val k: Int) {
    private val head: ListNode = ListNode(null)
    private val tail: ListNode = ListNode(null)
    private var len: Int = 0

    init {
        head.right = tail
        tail.left = head
    }

    private fun add(node: ListNode, new: ListNode) {
        val n = node.right
        node.right = new
        new.left = node
        new.right = n
        n?.left = new
    }

    private fun del(node: ListNode) {
        val n = node.right?.right
        node.right = n
        n?.left = node
    }

    fun insertFront(value: Int): Boolean {
        if (len == k) return false
        len++
        add(head, ListNode(value))
        return true
    }

    fun insertLast(value: Int): Boolean {
        if (len == k) return false
        len++
        add(tail.left!!, ListNode(value))
        return true
    }

    fun deleteFront(): Boolean {
        if (len == 0) return false
        len--
        del(head)
        return true
    }

    fun deleteLast(): Boolean {
        if (len == 0) return false
        len--
        del(tail.left!!.left!!)
        return true
    }

    fun getFront(): Int {
        return head.right?.`val` ?: -1
    }

    fun getRear(): Int {
        return tail.left?.`val` ?: -1
    }

    fun isEmpty(): Boolean {
        return len == 0
    }

    fun isFull(): Boolean {
        return len == k
    }
}

private class ListNode(var `val`: Int?) {
    var left: ListNode? = null
    var right: ListNode? = null
}