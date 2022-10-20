package Chapter15

import java.util.*

object Pack152 {
    //이진 탐색 소스코드 구현(재귀 함수)
    fun binarySearch(arr: IntArray, start: Int, end: Int): Int {
        if (start > end) return -1
        val mid = (start + end) / 2
        // 고정점을 찾은 경우 중간점 인덱스 반환
        return if (arr[mid] == mid) mid
        //중간점이 가리키는 위치의 값보다 중간점이 작은 경우 왼쪽 확인
        else if (arr[mid] > mid) binarySearch(arr, start, mid - 1)
        //중간점이 가리키는 위치의 값보다 중간점이 큰 경우 오른쪽 확인
        else binarySearch(arr, mid + 1, end)
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        val n = sc.nextInt()
        val arr = IntArray(n)
        for (i in 0 until n) arr[i] = sc.nextInt()
        //이진 탐색(Binary Search) 수행
        val index = binarySearch(arr, 0, n - 1)
        //결과 출력
        println(index)
    }
}