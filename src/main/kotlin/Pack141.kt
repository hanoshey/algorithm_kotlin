import java.util.Scanner

class Student2(val name: String, private val kor: Int, private val eng: Int, private val m: Int) :
    Comparable<Student2> {
    override fun compareTo(other: Student2): Int {
        if (this.kor == other.kor && this.eng == other.eng && this.m == other.m)
            return this.name.compareTo(other.name)
        if (this.kor == other.kor && this.eng == other.eng)
            return other.m.compareTo(this.m)
        if (this.kor == other.kor)
            return this.eng.compareTo(other.eng)
        return other.kor.compareTo(this.kor)
    }
    /*
    [정렬 기준]
    1. 국어 점수가 감소하는 순서로
    2. 국어 점수가 같으면 영어 점수가 증가하는 순서로
    3. 국어 점수와 영어 점수가 같으면 수학 점수가 감소하는 순서로
    4. 모든 점수가 같으면 이름이 사전 순으로 증가하는 순서로
     */
}

object Pack141 {
    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        val n = sc.nextInt()
        val students = ArrayList<Student2>()
        for (i in 0 until n) {
            val name = sc.next()
            val kor = sc.nextInt()
            val eng = sc.nextInt()
            val m = sc.nextInt()
            students.add(Student2(name, kor, eng, m))
        }
        students.sort()
        //정렬된 학생 정보에서 이름만 출력
        for (i in students)
            println(i.name)
    }
}