package utils

fun IntArray.printWithSpace() {
    this.forEach { print("$it ") }
    println()
}

fun Array<IntArray>.print() {
    this.forEach {
        it.printWithSpace()
    }
}