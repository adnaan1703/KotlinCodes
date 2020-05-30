package codegladiators

import java.lang.Long.min
import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val t = scanner.nextInt()
    val required = LongArray(t)
    val contains = LongArray(t)

    for (i in 0 until t) {
        required[i] = scanner.nextLong()
    }

    for (i in 0 until t) {
        contains[i] = scanner.nextLong()
    }

    var count = Long.MAX_VALUE
    for (i in 0 until t) {
        if (required[i] != 0L) {
            val quantity: Long = contains[i] / required[i]
            count = min(count, quantity)
        }
    }

    println(count)
}

