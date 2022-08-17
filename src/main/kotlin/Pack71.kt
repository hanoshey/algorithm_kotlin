import java.util.*

object Pack71 {
    //순차 탐색 소스코드 구현
    private fun sequantialSearch(n: Int, target: String, arr: Array<String>): Int {
        //각 원소를 하나씩 확인하여
        for (i in 0 until n) {
            println(arr[i])
            //현재의 원소가 찾고자 하는 원소와 동일한 경우
            if (arr[i] == target) return i + 1
        }
        return -1
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        println("생성할 원소 개수를 입력한 후 한 칸 띄고 찾을 문자열을 입력하세요")
        //원소의 개수
        val n = sc.nextInt()
        val target = sc.next()
        println("앞서 적은 개수만큼 문자열을 입력하세요. 구분은 띄어쓰기 한 칸")
        val arr = Array(n) { "" }
        for (i in 0 until n)
            arr[i] = sc.next()
        println(sequantialSearch(n, target, arr))
    }
}