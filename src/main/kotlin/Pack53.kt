object Pack53 {
    fun recursiveFunction() {
        println("재귀 함수를 호출합니다.")
        recursiveFunction()
    }

    @JvmStatic
    fun main(args: Array<String>) {
        recursiveFunction()
    }
}