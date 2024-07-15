package myleetcode

import myleetcode.types.ListNode

private class Problem328 {
    private fun oddEvenList(head: ListNode?): ListNode? {
        // 예외처리
        if (head == null) return null
        var odd: ListNode? = head
        var even: ListNode? = head.next
        val evenHead: ListNode? = even

        // 반복하면서 홀짝 노드 정리
        while (even?.next != null) {
            odd?.next = odd?.next?.next
            even.next = even.next?.next
            odd = odd?.next
            even = even.next
        }
        // 홀수 노드 마지막을 짝수 헤드로 연결
        odd?.next = evenHead
        return head
    }
}