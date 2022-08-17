object Pack83 {
    val d=LongArray(100)
    private fun fibo(x:Int):Long{
        print("f($x) ")
        if(x==1||x==2) return 1
        //이미 계산한 적 있는 문제라면 그대로 반환
        if(d[x]!=0L) return d[x]
        d[x]=fibo(x-1)+fibo(x-2)
        return d[x]
    }

    @JvmStatic
    fun main(args: Array<String>) {fibo(6)}
}