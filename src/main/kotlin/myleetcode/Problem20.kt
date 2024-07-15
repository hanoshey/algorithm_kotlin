package myleetcode

private fun main() {
    println(isValid("()[]{}"))
}

private fun isValid(s: String): Boolean {
    val stack = mutableListOf<Char>()
    val table = mapOf(')' to '(', '}' to '{', ']' to '[')
    for (char in s) {
        if (char !in table) {
            stack.add(char)
        } else if (stack.isEmpty() || table[char] != stack.removeAt(stack.size - 1)) {
            return false
        }
    }
    return stack.isEmpty()
}