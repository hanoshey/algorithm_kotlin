package myleetcode

import myleetcode.types.ListNode

private class Solution1Problem2 {
    //연결 리스트 뒤집기
    fun reverseList(head: ListNode?): ListNode? {
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

    //연결 리스트를 코틀린 리스트로 변환
    fun toList(node: ListNode?): List<Int> {
        val list = mutableListOf<Int>()
        var current = node
        while (current != null) {
            list.add(current.`val`)
            current = current.next
        }
        return list
    }

    // 코틀린 리스트를 연결 리스트로 변환
    fun toReversedLinkedList(result: String): ListNode? {
        var prev: ListNode? = null
        for (r in result) {
            val node = ListNode(r.digitToInt())
            node.next = prev
            prev = node
        }
        return prev
    }

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val a = toList(reverseList(l1))
        val b = toList(reverseList(l2))
        val resultStr = (a.joinToString("").toInt() + b.joinToString("").toInt()).toString()
        return toReversedLinkedList(resultStr)
    }
}

private class Problem2 {
    private fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode {
        val root = ListNode(0)
        var head = root
        var carry = 0
        var l1Curr = l1
        var l2Curr = l2
        while (l1Curr != null || l2Curr != null || carry != 0) {
            var sum = 0
            // 두 입력값의 합 계산
            if (l1Curr != null) {
                sum += l1Curr.`val`
                l1Curr = l1Curr.next
            }
            if (l2Curr != null) {
                sum += l2Curr.`val`
                l2Curr = l2Curr.next
            }
            //몫(자리올림수)와 나머지 계산
            val (newCarry, newVal) = (sum + carry).let { it / 10 to it % 10 }
            carry = newCarry
            head.next = ListNode(newVal)
            head = head.next!!
        }
        return root.next!!
    }
}