package myleetcode

import myleetcode.types.ListNode

private class Problem24 {
    private fun swapPairsSwapValue(head: ListNode?): ListNode? {
        var cur = head
        while (cur?.next != null) {
            // swap
            val temp = cur.`val`
            cur.`val` = cur.next!!.`val`
            cur.next!!.`val` = temp
            cur = cur.next!!.next
        }
        return head
    }

    private fun swapPairsRepeat(head: ListNode?): ListNode? {
        val root = ListNode(0)
        var prev = root
        prev.next = head
        var current = head
        while (current?.next != null) {
            val b = current.next
            current.next = b?.next
            b?.next = current
            prev.next = b
//            current = current.next
//            prev = prev.next?.next ?: prev
            prev = current
            current = current.next
        }
        return root.next
    }

    private fun swapPairsRecursive(head: ListNode?): ListNode? {
        if (head?.next != null) {
            val p = head.next
            // 스왑된 값 리턴 받음
            head.next = swapPairsRecursive(p?.next)
            p?.next = head
            return p
        }
        return head
    }
}