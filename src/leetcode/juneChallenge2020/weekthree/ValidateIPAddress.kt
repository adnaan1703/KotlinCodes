package leetcode.juneChallenge2020.weekthree

import utils.println

fun main() {
    validIPAddress("2001:0db8:85a3:0000:0000:8a2e:0370:7334").println()
    validIPAddress("2001:0db8:85a3:0000:0000:8a2e:0370:73342").println()
    validIPAddress("2001:0db8:85a3:0:0:8a2e:0370:7334").println()
    validIPAddress("2001:0db8:85a3:::8a2e:0370:7334").println()
    validIPAddress("172.16.254.1").println()
    validIPAddress("172.16.354.1").println()
    validIPAddress("172.16.254.01").println()
    validIPAddress("0.0.0.0").println()
}

/*
 * Could have done without Regex, with proper split and compare
 * But this is much more fun and easier.
 * ALso performs in par with split method. So win-win.
 */
fun validIPAddress(IP: String): String {
    val ipv6Regex = Regex("([A-F0-9]{1,4}:){7}[A-F0-9]{1,4}", RegexOption.IGNORE_CASE)
    val ipv4Regex = Regex(
        "((25[0-5]|2[0-4][0-9]|[1][0-9]{0,2}|[1-9]?[0-9])\\.){3}(25[0-5]|2[0-4][0-9]|[1][0-9]{0,2}|[1-9]?[0-9])",
        RegexOption.IGNORE_CASE
    )

    return when {
        ipv4Regex matches IP -> "IPv4"
        ipv6Regex matches IP -> "IPv6"
        else -> "Neither"
    }
}


