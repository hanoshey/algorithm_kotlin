package myleetcode

import myleetcode.types.ListNode

private class Problem92 {
    private fun reverseBetween(head: ListNode?, m: Int, n: Int): ListNode? {
        if (head == null || m == n) return head
        val root = ListNode(0)
        root.next = head
        var start: ListNode? = root

        //start 지정
        for (i in 1 until m) {
            start = start?.next
        }
        val end = start?.next
        //반복하면서 노드 차례대로 뒤집기
        for (i in 0 until n - m) {
            val temp = start?.next
            start?.next = end?.next
            end?.next = end?.next?.next
            start?.next?.next = temp
        }
        return root.next
    }
}