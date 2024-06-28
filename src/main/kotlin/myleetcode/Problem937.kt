package myleetcode

private fun reorderLogFiles(logs: Array<String>): Array<String> {
    val (letters, digits) = logs.partition { it.split(" ")[1].all { char -> char.isLetter() } }

    val sortedLetters = letters.sortedWith(compareBy(
        { it.substringAfter(" ") },
        { it.substringBefore(" ") }
    ))

    return sortedLetters.toTypedArray() + digits.toTypedArray()
}