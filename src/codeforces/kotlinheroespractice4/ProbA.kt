import java.io.PrintWriter

private fun readLn(): String = readLine()!!
private fun readInt(): Int = readLn().toInt()
private fun readDouble(): Double = readLn().toDouble()
private fun readLong(): Long = readLn().toLong()

private fun readStrings(): List<String> = readLn().split(" ")
private fun readInts(): List<Int> = readStrings().map { it.toInt() }
private fun readDoubles(): List<Double> = readStrings().map { it.toDouble() }
private fun readLongs(): List<Long> = readStrings().map { it.toLong() }

private val writer = PrintWriter(System.out, false)

fun main() {
//    val numCases = 1
    val numCases = readInt()
    for (case in 1..numCases) writer.solve()
    writer.flush()
}

private fun PrintWriter.solve() {
    val (a, b) = readInts()
    println(a + b)
}
