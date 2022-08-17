import java.util.Scanner

//계수 정렬 이용하여 풀기 탐색
object Pack76 {
   @JvmStatic
   fun main(args: Array<String>) {
      val sc=Scanner(System.`in`)
      //N(가게의 부품 개수)
      val n=sc.nextInt()
      val arr=IntArray(1000001)
      for(i in 0 until n){
         val x=sc.nextInt()
         arr[x]=1
      }
      //M(손님이 확인 요청한 부품 개수)
      val m=sc.nextInt()
      val targets=IntArray(n)
      for(i in 0 until m)
         targets[i]=sc.nextInt()
      for(i in 0 until m){
         if (arr[targets[i]]==1) print("yes ")
         else print("no ")
      }
   }
}