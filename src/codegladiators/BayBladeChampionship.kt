package codegladiators

import java.util.*

val scanner = Scanner(System.`in`)

fun main() {
    val t = scanner.nextInt()
    for (i in 0 until t) {
        solve()
    }
}

fun solve() {
    val n = scanner.nextInt()
    val gForce = LongArray(n)
    val opponent = LongArray(n)

    for (i in 0 until n) {
        gForce[i] = scanner.nextLong()
    }

    for (i in 0 until n) {
        opponent[i] = scanner.nextLong()
    }

    gForce.sortDescending()
    opponent.sortDescending()

    var counter = 0
    var ptr1 = 0
    var ptr2 = 0

    while (ptr1 < n && ptr2 < n) {
        if (gForce[ptr1] > opponent[ptr2]) {
            counter++
            ptr1++
            ptr2++
        } else {
            ptr2++
        }
    }
    println(counter)
}
