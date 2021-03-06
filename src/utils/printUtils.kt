package utils

fun Int.print() {
    print(this)
}

fun Int.println() {
    println(this)
}

fun Boolean.print() {
    print(this)
}

fun Boolean.println() {
    println(this)
}

fun String.print() {
    print(this)
}

fun String.println() {
    println(this)
}

fun <T> List<T>.print() {
    println(this)
}

fun CharArray.printWithSpaces() {
    this.forEach { print("$it ") }
    println()
}

fun Array<CharArray>.print() {
    this.forEach {
        it.printWithSpaces()
    }
}

fun LongArray.print() {
    this.forEach { print("$it ") }
    println()
}