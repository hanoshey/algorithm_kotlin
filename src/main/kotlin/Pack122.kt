import java.util.*
import kotlin.collections.ArrayList

object Pack122 {
    var str = ""
    val result = ArrayList<Char>()
    var value = 0

    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        str = sc.next()
        //문자를 하나씩 확인하며
        for (i in str.indices) {
            //알파벳인 경우 결과 리스트에 삽입
            if (Character.isLetter(str[i]))
                result.add(str[i])
            //숫자는 따로 더하기
            else value += str[i] - '0'
        }
        //알파벳을 오름차순으로 변환
        result.sort()
        //알파벳을 차례대로 출력
        for (i in 0 until result.size)
            print(result[i])
        //숫자가 하나라도 존재하는 경우 가장 뒤에 출력
        if (value != 0) print(value)
        println()
    }
}