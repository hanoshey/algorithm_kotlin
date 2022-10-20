package Chapter7

import java.util.Scanner

object Pack75 {
    //이진 탐색 소스코드 구현(반복문)
    private fun binarySearch(arr: IntArray, target: Int, start: Int, end: Int): Int {
        var start = start
        var end = end
        while (start <= end) {
            val mid = (start + end) / 2
            if (arr[mid] == target) return mid
            else if (arr[mid] > target) end = mid - 1
            else start = mid + 1
        }
        return -1
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        //N(가게의 부품 개수)
        val n = sc.nextInt()
        val arr = IntArray(n)
        for (i in 0 until n)
            arr[i] = sc.nextInt()
        //이진 탐색 수행하기 위해 사전에 정렬 수행
        arr.sort()
        val m = sc.nextInt()
        val targets = IntArray(m)
        for (i in 0 until m)
            targets[i] = sc.nextInt()
        //손님이 확인 요청한 부품 번호를 하나씩 확인
        for (i in 0 until m) {
            //해당 부품이 존재하는지 확인
            val result = binarySearch(arr, targets[i], 0, n - 1)
            if (result != -1) print("yes ")
            else print("no ")
        }
    }
}