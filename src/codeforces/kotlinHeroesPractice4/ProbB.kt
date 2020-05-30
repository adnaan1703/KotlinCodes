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
    val dimen1 = readLongs().toLongArray()
    val dimen2 = readLongs().toLongArray()

    fun correct() = (dimen1[0] == dimen2[0] && dimen1[1] + dimen2[1] == dimen1[0])
            || (dimen1[1] == dimen2[1] && dimen1[0] + dimen2[0] == dimen1[1])


    val ans = run {
        if (correct()) return@run true
        dimen1.swap()
        correct()
    }

    println(if (ans) "Yes" else "No")
}

private fun LongArray.swap() {
    val temp = this[0]
    this[0] = this[1]
    this[1] = temp
}

