package myleetcode

import java.security.MessageDigest
import kotlin.random.Random
import kotlin.random.nextInt

private fun main() {
    sameBirthday()
    val input = "example input"
    val uuidStyleHash = generateUuidStyleHash(input)
    println(uuidStyleHash)
}

private fun sameBirthday() {
    val TRIALS = 1000000
    var sameBirthdays = 0
    repeat(TRIALS) {
        val birthdays = mutableListOf<Int>()
        for (j in 0 until 23) {
            val birthday = Random.nextInt(1, 365)
            if (birthday in birthdays) {
                sameBirthdays++
                break
            }
            birthdays.add(birthday)
        }
    }
    println("${(sameBirthdays.toFloat() / TRIALS.toFloat()) * 100}%")
}


fun generateUuidStyleHash(input: String): String {
    val hash = hashString("SHA-256", input)
    println(hash)
    return formatToUuidStyle(hash)
}

fun hashString(type: String, input: String): String {
    val bytes = MessageDigest.getInstance(type).digest(input.toByteArray())
    return bytes.joinToString("") { "%02x".format(it) }
}

fun formatToUuidStyle(hash: String): String {
    return hash.substring(0, 8) + "-" +
            hash.substring(8, 12) + "-" +
            hash.substring(12, 16) + "-" +
            hash.substring(16, 20) + "-" +
            hash.substring(20, 32)
}
