package leetcode.aprilChallenge2020.weektwo

fun main() {
    println(backspaceCompare("ab#c", "ad#c"))   // ans: true
    println(backspaceCompare("ab##", "c#d#"))   // ans: true
    println(backspaceCompare("a##c", "#a#c"))   // ans: true
    println(backspaceCompare("a#c", "b"))       // ans: false
    println(backspaceCompare("a#", ""))         // ans: true
    println(backspaceCompare("a#b", "#b"))      // ans: true
}

fun backspaceCompare(S: String, T: String): Boolean {
    var ptr1 = S.length
    var ptr2 = T.length

    while (ptr1 >= 0 && ptr2 >= 0) {
        ptr1 = findNextPtr(S, ptr1 - 1)
        ptr2 = findNextPtr(T, ptr2 - 1)

        if (S.safeGet(ptr1) != T.safeGet(ptr2))
            return false
    }

    return true
}

private fun String.safeGet(index: Int): Char? {
    return if (index < this.length && index >= 0) this[index] else null
}

fun findNextPtr(str: String, index: Int): Int {

    var ptr: Int = index
    var ignore = 0
    while (ptr >= 0) {
        if (str[ptr] != '#') {
            if (ignore == 0)
                break
            else
                ignore--
        } else {
            ignore++
        }
        ptr--
    }
    return ptr
}