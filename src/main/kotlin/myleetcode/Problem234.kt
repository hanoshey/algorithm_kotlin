package myleetcode

import myleetcode.types.ListNode

private fun main() {
    val head = ListNode(1)
    head.next = ListNode(2)
    head.next!!.next = ListNode(2)
    head.next!!.next!!.next = ListNode(1)
    println(isPalindromeRunner(head))
}

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
private fun isPalindromeList(head: ListNode?): Boolean {
    val q = mutableListOf<Int>()
    if (head == null) return true
    var node: ListNode? = head
    //리스트 변환
    while (node != null) {
        q.add(node.`val`)
        node = node.next
    }
    //팰린드롬 판별
    while (q.size > 1) {
        if (q.removeAt(0) != q.removeAt(q.size - 1)) {
            return false
        }
    }
    return true
}

private fun isPalindromeDeque(head: ListNode?): Boolean {
    val q = ArrayDeque<Int>()
    if (head == null) return true
    var node = head
    while (node != null) {
        q.add(node.`val`)
        node = node.next
    }
    while (q.size > 1) {
        if (q.removeFirst() != q.removeLast()) {
            return false
        }
    }
    return true
}

private fun isPalindromeRunner(head: ListNode?): Boolean {
    var rev: ListNode? = null
    var slow = head
    var fast = head

    // 런너를 이용해 역순 연결 리스트 구성
    while (fast?.next != null) {
        fast = fast.next!!.next
        val next = slow!!.next
        slow.next = rev
        rev = slow
        slow = next
    }
    if (fast != null) slow = slow!!.next
    // check if it is a palindrome
    while (rev != null && slow != null && rev.`val` == slow.`val`) {
        println("rev.val = ${rev.`val`}, slow.val = ${slow.`val`}")
        slow = slow.next
        rev = rev.next
    }
    println(rev?.`val`)
    return rev == null
}
