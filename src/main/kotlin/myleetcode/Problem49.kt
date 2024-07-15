package myleetcode

private fun groupAnagrams(strs: Array<String>): List<List<String>> {
//    val dict = mutableMapOf<String, List<String>>()
//    strs.forEach { word ->
//        word.split("").sorted().joinToString("").let { sorted ->
//            dict[sorted] = dict.getOrDefault(sorted, listOf()) + word
//        }
//    }
//    return dict.values.toList()
    val dict = mutableMapOf<String, MutableList<String>>()
    strs.forEach { word ->
        val sorted = word.toCharArray().sorted().joinToString("")
        dict.getOrPut(sorted) { mutableListOf() }.add(word)
    }
    return dict.values.toList()
}

private fun main() {
    println(groupAnagrams(arrayOf("eat", "tea", "tan", "ate", "nat", "bat")))
}