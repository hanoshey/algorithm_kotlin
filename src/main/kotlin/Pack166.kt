import java.util.*

object Pack166 {
    var str1=""
    var str2=""
    //최소 편집 거리(Edit Distance) 계산을 위한 다이나믹 프로그래밍 진행
    fun editDist(str1:String,str2:String):Int{
        val n=str1.length
        val m=str2.length
        //다이나믹 프로그래밍을 위한 2차원 DP 테이블 초기화
        val dp=Array(n+1){IntArray(m+1)}
        //DP 테이블 초기 설정
        for(i in 0..n) dp[i][0]=i
        for(j in 0..m) dp[0][j]=j
        //최소 편집 거리 계산
        for(i in 1..n)
            for(j in 1..m){
                //문자가 같다면, 왼쪽 위에 해당하는 수를 그대로 대입
                if(str1[i-1]==str2[j-1]) dp[i][j]=dp[i-1][j-1]
                //문자가 다르다면, 3가지 경우 중에서 최솟값 찾기
                //삽입(왼쪽), 삭제(위쪽), 교체(왼쪽 위) 중에서 최소 비용을 찾아 대입
                else dp[i][j]=1+minOf(dp[i][j-1],dp[i-1][j],dp[i-1][j-1])
            }
        return dp[n][m]
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        str1=sc.next()
        str2=sc.next()
        //최소 편집 거리 출력
        println(editDist(str1,str2))
    }
}