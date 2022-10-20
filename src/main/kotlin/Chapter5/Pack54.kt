package Chapter5

object Pack54 {
    fun recursiveFunction(i: Int) {
        //100번째 호출 때 중단되도록 명시
        if (i == 100) return
        println("${i}번째 재귀 함수에서 ${i + 1}번째 재귀함수를 호출합니다.")
        recursiveFunction(i + 1)
        println("${i}번째 재귀 함수를 종료합니다.")
    }

    @JvmStatic
    fun main(args: Array<String>) {
        recursiveFunction(1)
    }
}