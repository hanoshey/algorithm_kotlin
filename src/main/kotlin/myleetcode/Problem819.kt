package myleetcode

private fun mostCommonWord(paragraph: String, banned: Array<String>): String {
//    val regex = "[^\\w]".toRegex()
//    val words = regex.replace(paragraph, " ")
//        .lowercase()
//        .split("\\s+".toRegex())
//        .filter { it.isNotEmpty() && it !in banned }
//    val wordMap = mutableMapOf<String, Int>()
//    words.toSet().forEach { setWord ->
//        wordMap.put(setWord, words.count { word -> word == setWord })
//    }
//    return wordMap.maxByOrNull { it.value }?.key ?: ""
    //More efficient code.
    val bannedSet = banned.toSet()
    val wordFrequency = mutableMapOf<String, Int>()
    paragraph.split("\\W+".toRegex())
        .map { it.lowercase() }
        .filter { it.isNotEmpty() && it !in bannedSet }
        .forEach { word ->
            wordFrequency[word] = wordFrequency.getOrDefault(word, 0) + 1
        }

    return wordFrequency.maxByOrNull { it.value }?.key ?: ""
}

private fun main() = with(System.`in`.bufferedReader()) {
    println(mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", arrayOf("hit")))
    println(mostCommonWord("a.", arrayOf()))
}