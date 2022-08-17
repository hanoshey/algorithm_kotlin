object Pack62 {
    @JvmStatic
    fun main(args: Array<String>) {
        val arr= intArrayOf(3,5)
        //스와프
        val temp=arr[0]
        arr[0]=arr[1]
        arr[1]=temp
        println("${arr[0]} ${arr[1]}")
    }
}