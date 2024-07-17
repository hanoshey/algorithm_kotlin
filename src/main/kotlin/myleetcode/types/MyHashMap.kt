package myleetcode.types
class MyHashMap {

    private val size = 1000
    private val table = Array<ListNode?>(size) { null }

    data class ListNode(val key: Int, var value: Int, var next: ListNode? = null)

    fun put(key: Int, value: Int) {
        val index = key % size
        if (table[index] == null) {
            table[index] = ListNode(key, value)
            return
        }

        var p = table[index]
        while (p != null) {
            if (p.key == key) {
                p.value = value
                return
            }
            if (p.next == null) {
                break
            }
            p = p.next
        }
        p!!.next = ListNode(key, value)
    }

    fun get(key: Int): Int {
        val index = key % size
        var p = table[index] ?: return -1

        while (true) {
            if (p.key == key) {
                return p.value
            }
            p = p.next!!
        }
    }

    fun remove(key: Int) {
        val index = key % size
        var p = table[index] ?: return

        if (p.key == key) {
            table[index] = p.next
            return
        }

        var prev = p
        while (true) {
            if (p.key == key) {
                prev.next = p.next
                return
            }
            prev = p
            p = p.next!!
        }
    }
}
