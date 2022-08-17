import java.util.Scanner

class Student(val name:String, val score:Int)
object Pack611{
    @JvmStatic
    fun main(args: Array<String>) {
        val sc=Scanner(System.`in`)
        val n=sc.nextInt()
        val students:MutableList<Student> =ArrayList()
        for(i in 0 until n){
            val name=sc.next()
            val score=sc.nextInt()
            students.add(Student(name,score))
        }
        students.sortBy { it.score }
        for(i in students.indices)
            print("${students[i].name} ")
    }
}
