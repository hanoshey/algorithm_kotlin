package Chapter20

object Pack204 {
    //사전에 정렬된 리스트 A와 B 선언
    val n = 3
    val m = 4
    val a = intArrayOf(1, 3, 5)
    val b = intArrayOf(2, 4, 6, 8)

    //리스트 A와 B의 모든 원소를 담을 수 있는 크기의 결과 리스트 초기화
    val result = IntArray(n + m) { 0 }
    var i = 0
    var j = 0
    var k = 0

    @JvmStatic
    fun main(args: Array<String>) {
        //모든 원소가 결과 리스트에 담길 때까지 반복
        while (i < n || j < m) {
            //리스트 B의 모든 원소가 처리되었거나, 리스트 A의 원소가 더 적을 때
            if (j >= m || (i < n && a[i] <= b[j])) {
                result[k] = a[i]
                i += 1
            }
            //리스트 A의 모든 원소가 처리되었거나, 리스트 B의 원소가 더 적을 때
            else {
                result[k] = b[j]
                j += 1
            }
            k += 1
        }
        result.forEach { print("$it ") }
    }

}