package Chapter12

import java.util.*

private var str = ""
private var summary = 0

private fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    str = sc.next()
    //왼쪽 부분의 자릿수 합 더하기
    for (i in 0 until str.length / 2)
        summary += str[i] - '0'
    //오른쪽 부분의 자릿수의 합 빼기
    for (i in str.length / 2 until str.length)
        summary -= str[i] - '0'
    //왼쪽 부분과 오른쪽 부분의 자릿수 합이 동일한지 검사하기
    if (summary == 0) println("LUCKY")
    else println("READY")
}