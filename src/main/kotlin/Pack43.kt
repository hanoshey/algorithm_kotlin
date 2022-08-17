import java.util.Scanner

object Pack43 {
    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        val inputData = sc.nextLine()
        //현재 나이트의 위치 입력받기
        val row = inputData[1] - '0'
        val column = inputData[0] - 'a' + 1
        //나이트가 이동할 수 있는 8가지 방향 정의
        val dx = intArrayOf(-2, -1, 1, 2, 2, 1, -1, -2)
        val dy = intArrayOf(-1, -2, -2, -1, 1, 2, 2, 1)
        var result = 0
        for (i in 0 until 8) {
            val nextRow = row + dx[i]
            val nextColumn = column + dy[i]
            if (nextRow >= 1 && nextRow <= 8 && nextColumn >= 1 && nextColumn <= 8) {
                result +=1
            }
        }
        println(result)
    }
}