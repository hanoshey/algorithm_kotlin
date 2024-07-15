package myleetcode

import myleetcode.types.ListNode
import java.util.PriorityQueue

private fun mergeKLists(lists: Array<ListNode?>): ListNode? {
    val root = ListNode(0)
    var result: ListNode? = root
    val heap = PriorityQueue(compareBy<Triple<Int, Int, ListNode>> { it.first })
    // 각 연결리스트의 루트를 힙에 저장
    for (i in lists.indices) {
        lists[i]?.let {
            heap.add(Triple(it.`val`, i, it))
        }
    }
    //힙 추출 이후 다음 노드는 다시 저장
    while (heap.isNotEmpty()) {
        val node = heap.poll()
        val idx = node.second
        result?.next = node.third
        result = result?.next
        result?.next?.let {
            heap.add(Triple(it.`val`, idx, it))
        }
    }
    return root.next
}