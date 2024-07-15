package myleetcode

private fun longestPalindrome(s: String): String {
    fun expand(left: Int, right: Int): String {
        var l = left
        var r = right
        while (l >= 0 && r < s.length && s[l] == s[r]) {
            l--
            r++
        }
        return s.substring(l + 1, r)
    }
    // return quickly when there are no applicable cases
    if (s.length < 2 || s == s.reversed()) return s
    var result = ""
    // move sliding window to the right
    for (i in 0 until s.length - 1) {
        result = listOf(result, expand(i, i + 1), expand(i, i + 2)).maxByOrNull { it.length } ?: result
    }
    return result
}

private fun main() {
    println(longestPalindrome("aaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbw"))
}


