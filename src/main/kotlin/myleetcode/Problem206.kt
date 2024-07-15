package myleetcode

import myleetcode.types.ListNode

private fun main() {

}

private fun reverseListRecursive(head: ListNode?): ListNode? {
    fun reverse(node: ListNode?, prev: ListNode? = null): ListNode? {
        if (node == null)
            return prev
        val next = node.next
        node.next = prev
        return reverse(next, node)
    }
    return reverse(head)
}

private fun reverseListRepeat(head: ListNode?): ListNode? {
    var node = head
    var prev: ListNode? = null
    while (node != null) {
        val next = node.next
        node.next = prev
        prev = node
        node = next
    }
    return prev
}