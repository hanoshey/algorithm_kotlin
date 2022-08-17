object Pack63 {
    @JvmStatic
    fun main(args: Array<String>) {
        val n = 10
        val arr = intArrayOf(7, 5, 9, 0, 3, 1, 6, 2, 4, 8)
        for (i in 1 until n) {
            for (j in i downTo 1) {
                if (arr[j] < arr[j - 1]) {
                    val temp = arr[j]
                    arr[j] = arr[j - 1]
                    arr[j - 1] = temp
                } else break
            }
        }
        for (i in 0 until n)
            print("${arr[i]} ")
    }
}