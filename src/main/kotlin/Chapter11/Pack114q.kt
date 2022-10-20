package Chapter11

import java.util.*
import kotlin.collections.ArrayList

object Pack114q {
    var n = 0
    val arrayList = ArrayList<Int>()

    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        n = sc.nextInt()
        for (i in 0 until n) arrayList.add(sc.nextInt())
        arrayList.sort()
        var target = 1
        for (i in 0 until n) {
            //만들 수 없는 금액을 찾았을 때 반복 종료
            if (target < arrayList[i]) break
            target += arrayList[i]
        }
        println(target)
    }
}