package Chapter11

import java.util.*

private var n = 0
private val arrayList = ArrayList<Int>()

private fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    n = sc.nextInt()
    for (i in 0 until n) arrayList.add(sc.nextInt())
    arrayList.sort()
    var result = 0//총 그룹의 수
    var count = 0//현재 그룹에 포함된 모험가의 수
    for (i in 0 until n) {//공포토가 낮은 것부터 하나씩 확인
        count += 1//현재 그룹에 해당 모험가를 포함시키기
        if (count >= arrayList[i]) {
            //현재 그룹에 포함된 모험가의 수가 현재의 공포도 이상이라면, 그룹 결성
            result += 1
            count = 0
        }
    }
    println(result)
}