import java.util.*

object Pack73 {
    //이진 탐색 반복문
    private fun binarySearch(arr: IntArray, target: Int, start: Int, end: Int): Int {
        var start = start
        var end = end
        while (start <= end) {
            val mid = (start + end) / 2
            // 찾은 경우 중간점 인덱스 반환
            if (arr[mid] == target) return mid
            else if (arr[mid] > target) end = mid - 1
            else start = mid + 1
        }
        return -1
    }

    @JvmStatic
    fun main(args: Array<String>) {
        //원소의 개수n과 찾고자 하는 값target 입력받기
        val sc = Scanner(System.`in`)
        val n = sc.nextInt()
        val target = sc.nextInt()
        //전체 원소 입력받기
        val arr = IntArray(n)
        for (i in 0 until n)
            arr[i] = sc.nextInt()
        //이진 탐색 수행 결과 출력
        val result = binarySearch(arr, target, 0, n - 1)
        if (result == -1)
            println("원소가 존재하지 않습니다.")
        else
            println(result + 1)
    }
}