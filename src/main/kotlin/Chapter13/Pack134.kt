package Chapter13

class Pack134 {
    //"균형잡힌 괄호 문자열"의 인덱스 반환
    fun balancedIndex(p: String): Int {
        var count = 0//왼쪽 괄호의 개수
        for (i in p.indices) {
            if (p[i] == '(') count += 1
            else count -= 1
            if (count == 0) return i
        }
        return -1
    }

    //"올바른 괄호 문자열"인지 판단
    fun checkProper(p: String): Boolean {
        var count = 0//왼쪽 괄호의 개수
        for (i in p.indices) {
            if (p[i] == '(') count += 1
            else {
                if (count == 0) return false//쌍이 맞지 않는 경우에 false 반환
                count -= 1
            }
        }
        return true//쌍이 맞는 경우에 true 반환
    }

    fun solution(p: String): String {
        var answer = ""
        if (p == "") return answer
        val index = balancedIndex(p)
        var u = p.substring(0, index + 1)
        val v = p.substring(index + 1)
        //"올바른 괄호 문자열"이면, v에 대해 함수를 수행한 결과를 붙여 반환
        if (checkProper(u))
            answer = u + solution(v)
        //"올바른 괄호 문자열"이 아니라면 아래의 과정을 수행
        else {
            answer = "("
            answer += solution(v)
            answer += ")"
            u = u.substring(1, u.length - 1)//첫 번째 문자와 마지막 문자 제거
            var temp = ""
            for (i in u.indices)
                temp += if (u[i] == '(') ")" else "("
            answer += temp
        }
        return answer
    }
}