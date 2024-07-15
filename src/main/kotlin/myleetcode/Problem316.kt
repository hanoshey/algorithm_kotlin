package myleetcode

import java.util.*

private fun main() {
    println(removeDuplicateLettersRecur("eaabfbebaawwddfdvsgrhwjwjhwrwwgz"))
    println(removeDuplicateLetters("eaabfbebaawwddfdvsgrhwjwjhwrwwgz"))
    println(removeDuplicateLetters2("eaabfbebaawwddfdvsgrhwjwjhwrwwgz"))
}

private fun removeDuplicateLettersRecur(s: String): String {
    // 집합으로 정렬
    println("s.toset().sorted() : ${s.toSet().sorted()}")
    for (char in s.toSet().sorted()) {
        val suffix = s.substring(s.indexOf(char))
        println("suffix: $suffix")
        // 전체 집합과 접미사 집합이 일치할 때 분리 진행
        println("s: $s")
        println("suffix.toSet(): ${suffix.toSet()}")
        if (s.toSet() == suffix.toSet()) {
            return char + removeDuplicateLettersRecur(suffix.replace(char.toString(), ""))
        }
    }
    return ""
}

private fun removeDuplicateLetters(s: String): String {
    val counter = s.groupingBy { it }.eachCount().toMutableMap()
    val seen = mutableSetOf<Char>()
    val stack = mutableListOf<Char>()
    for (char in s) {
        counter[char] = counter[char]!! - 1
        if (char in seen) continue
        while (stack.isNotEmpty() && char < stack.last() && counter[stack.last()]!! > 0) {
            seen.remove(stack.removeAt(stack.size - 1))
        }
        stack.add(char)
        seen.add(char)
    }
    return stack.joinToString("")
}
fun removeDuplicateLetters2(s: String): String {
    val counter = mutableMapOf<Char, Int>()
    val seen = mutableSetOf<Char>()
    val stack = LinkedList<Char>()

    // Initialize the counter
    for (char in s) {
        counter[char] = counter.getOrDefault(char, 0) + 1
    }

    for (char in s) {
        counter[char] = counter[char]!! - 1
        if (char in seen) continue
        // Remove characters from the stack if necessary
        while (stack.isNotEmpty() && char < stack.peekLast() && counter[stack.peekLast()]!! > 0) {
            seen.remove(stack.removeLast())
        }
        stack.add(char)
        seen.add(char)
    }
    return stack.joinToString("")
}