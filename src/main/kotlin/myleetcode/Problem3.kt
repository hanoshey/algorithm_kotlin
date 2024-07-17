package myleetcode

import kotlin.math.max

private fun main() {
    println(lengthOfLongestSubstring("abcabcbb"))
    println(lengthOfLongestSubstring("bbbbba"))
    println(lengthOfLongestSubstring("pwwkew"))
}

private fun lengthOfLongestSubstring(s: String): Int {
    val used = mutableMapOf<Char, Int>()
    var start = 0
    var maxLength = 0
    for ((index, char) in s.withIndex()) {
        // 이미 등장했던 문자라면 'start'위치갱신
        if (char in used && start <= (used[char] ?: 0)) {
            println("char : $char")
            start = (used[char] ?: 0) + 1
            println("start: $start")
        } else { // 최대 부분 문자열 길이 갱신
            println("char : $char")
            maxLength = max(maxLength, index - start + 1)
            println("maxLength : $maxLength")
        }
        // 현재 문자의 위치 삽입
        used[char] = index
    }
    return maxLength
}