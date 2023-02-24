package mybaekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main() {
    val bi = BufferedReader(InputStreamReader(System.`in`))
    val token = StringTokenizer(bi.readLine())
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val c = token.nextToken().toDouble() / token.nextToken().toDouble()
    bw.write("${c}\n")
    bw.flush()
    bw.close()
}