package Chapter6

object Pack61 {
    @JvmStatic
    fun main(args: Array<String>) {
        val n = 10
        val arr = intArrayOf(7, 5, 9, 0, 3, 1, 6, 2, 4, 8)
        for (i in 0 until n) {
            var min_index = i//가장 작은 원소의 인덱스
            for (j in i + 1 until n)
                if (arr[min_index] > arr[j])
                    min_index = j
            val temp = arr[i]
            arr[i] = arr[min_index]
            arr[min_index] = temp
        }
        for (i in 0 until n)
            print("${arr[i]} ")
    }
}