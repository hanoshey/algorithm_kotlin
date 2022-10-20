package Chapter7

import java.util.Scanner

object Pack72 {
    private fun binarySearch(arr: IntArray, target: Int, start: Int, end: Int): Int {
        if (start > end) return -1
        val mid = (start + end) / 2
        //찾은 경우 중간점 인덱스 반환
        if (arr[mid] == target) return mid
        //중간점의 값보다 찾고자 하는 값이 작은 경우 왼쪽 확인
        else if (arr[mid] > target) return binarySearch(arr, target, start, mid - 1)
        //중간점의 값보다 찾고자 하는 값이 큰 경우 오른쪽 확인
        else return binarySearch(arr, target, mid + 1, end)
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        val n = sc.nextInt()
        val target = sc.nextInt()
        //전체 원소 입력받기
        val arr = IntArray(n)
        for (i in 0 until n)
            arr[i] = sc.nextInt()
        val result = binarySearch(arr, target, 0, n - 1)
        if (result == -1) println("원소가 존재하지 않습니다.")
        else println(result + 1)
    }
}