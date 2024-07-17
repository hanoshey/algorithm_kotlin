package myleetcode

private fun main() {
    println(newJewelsInStonesPy("aA", "aAAbbbb"))
}

private fun newJewelsInStonesHash(jewels: String, stones: String): Int {
    val freqs = mutableMapOf<Char, Int>()
    var count = 0
    for (char in stones) {
        freqs[char] = (freqs[char] ?: 0) + 1
    }
    for (char in jewels) {
        if (char in freqs) count += freqs[char]!!
    }
    return count
}

private fun newJewelsInStonesCounter(jewels: String, stones: String): Int {
    val freqs = stones.groupingBy { it }.eachCount().toMutableMap()
    var count = 0
    for (char in jewels) {
        count += freqs[char] ?: continue
    }
    return count
}
private fun newJewelsInStonesPy(jewels: String,stones:String):Int{
    return stones.count { it in jewels }
}