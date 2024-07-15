package myleetcode

import kotlin.random.Random
import kotlin.random.nextInt

private fun main() {
    sameBirthday()
}

private fun sameBirthday() {
    val TRIALS = 1000000
    var sameBirthdays = 0
    //10만번 실험 진행
    repeat(TRIALS) {
        val birthdays = mutableListOf<Int>()
        //23명이 모였을 때 생일이 같은 경우
        for (j in 0 until 23) {
            val birthday = Random.nextInt(1, 365)
            if (birthday in birthdays) {
                sameBirthdays++
                break
            }
            birthdays.add(birthday)
        }
    }
    println(sameBirthdays)
    println("${(sameBirthdays.toFloat() / TRIALS.toFloat()) * 100}%")

}
