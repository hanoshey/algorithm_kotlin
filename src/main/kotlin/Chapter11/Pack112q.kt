package Chapter11

import java.util.*

private fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val str = sc.next()
    //첫 번째 문자를 숫자로 변경한 값을 대입
    var result = (str[0] - '0').toLong()
    for (i in 1 until str.length) {
        //두 수 중에서 하나라도 '0' 또는 '1'일 경우,
        //곱하기보다는 더하기 수행
        val num = str[i] - '0'
        if (num <= 1 || result <= 1) result += num
        else result *= num
    }
    println(result)
}