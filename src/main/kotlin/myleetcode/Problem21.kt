package myleetcode

import myleetcode.types.ListNode

private fun main() {
println(mergeTwoLists(ListNode(2),ListNode(5))?.`val`)
    println(mergeTwoLists(ListNode(2),ListNode(5))?.next)
}

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 */

private fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    var l1 = list1
    var l2 = list2
    if (l1 == null || (l2 != null && l1.`val` > l2.`val`)) {
        val temp = l1
        l1 = l2
        l2 = temp
    }
    if (l1 != null) {
        l1.next = mergeTwoLists(l1.next, l2)
    }
    return l1
}