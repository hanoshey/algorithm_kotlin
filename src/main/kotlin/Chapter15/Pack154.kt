package Chapter15

class Solution8 {
    fun lowerBound(arr: ArrayList<String>, target: String, start: Int, end: Int): Int {
        var start = start
        var end = end
        while (start < end) {
            val mid = (start + end) / 2
            //arr[mid]가 target보다 사전순으로 같거나 뒤에 있다면
            if (arr[mid] >= target) end = mid
            else start = mid + 1
        }
        return end
    }

    fun upperBound(arr: ArrayList<String>, target: String, start: Int, end: Int): Int {
        var start = start
        var end = end
        while (start < end) {
            val mid = (start + end) / 2
            //arr[mid]가 target보다 사전순으로 뒤에 있다면
            if (arr[mid] > target) end = mid
            else start = mid + 1
        }
        return end
    }

    //값이 [left_value,right_value]인 데이터의 개수를 반환하는 함수
    fun countByRange(arr: ArrayList<String>, leftValue: String, rightValue: String): Int {
        //유의:lowerBound와 upperBound는 end 변수의 값을 배열의 길이로 설정
        val rightIndex = upperBound(arr, rightValue, 0, arr.size)
        val leftIndex = lowerBound(arr, leftValue, 0, arr.size)
        return rightIndex - leftIndex
    }

    //모든 단어들을 길이마다 나누어서 저장하기 위한 리스트
    val arr = ArrayList<ArrayList<String>>()

    //모든 단어들을 길이마다 나누어서 뒤집어 저장하기 위한 리스트
    var reversedArr = ArrayList<ArrayList<String>>()
    fun solution(words: Array<String>, queries: Array<String>): IntArray {
        val ans = ArrayList<Int>()
        //단어의 길이는 10,000까지 가능
        for (i in 0 until 10001) {
            arr.add(ArrayList())
            reversedArr.add(ArrayList())
        }
        //모든 단어를 접미사 와일드카드 배열, 접두사 와일드카드 배열에 각각 삽입
        for (i in words) {
            arr[i.length].add(i)//단어를 삽입
            reversedArr[i.length].add(i.reversed())//단어를 뒤집어서 삽입
        }
        //이진 탐색을 수행하기 위해 각 단어 리스트 정렬 수행
        for (i in 0 until 10001) {
            arr[i].sort()
            reversedArr[i].sort()
        }
        //쿼리를 하나씩 확인하며 처리
        for (i in queries) {
            var res = 0
            if (i[0] != '?')//접미사에 와일드카드가 붙은 경우
                res = countByRange(arr[i.length], i.replace('?', 'a'), i.replace('?', 'z'))
            else//접두사에 와일드카드가 붙은 경우
                res = countByRange(
                    reversedArr[i.length], i.reversed().replace('?', 'a'),
                    i.reversed().replace('?', 'z')
                )
            ans.add(res)
        }
        return ans.toIntArray()
    }
}
