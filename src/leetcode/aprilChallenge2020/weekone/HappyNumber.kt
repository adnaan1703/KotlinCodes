package leetcode.aprilChallenge2020.weekone

fun main() {
    println(isHappy(19))
    println(isHappy(21))
}

fun isHappy(n: Int): Boolean {
    var num: Long = n.toLong()
    val map = HashMap<Long, Boolean>()
    while (num != 1L && !map.containsKey(num)) {
        map[num] = true
        num = getSquaredDigits(num)
    }
    return num == 1L
}

fun getSquaredDigits(n: Long): Long {
    var num = n
    var sum = 0L
    while (num > 0) {
        val d = num % 10
        num /= 10L
        sum += (d * d)
    }
    return sum
}