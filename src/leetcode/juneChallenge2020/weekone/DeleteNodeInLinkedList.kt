package leetcode.juneChallenge2020.weekone

import utils.ListNode
import utils.createLinkList
import utils.printLinkList

fun main() {
    val head = createLinkList(intArrayOf(1, 2, 3, 4))
    deleteNode(head?.next?.next)
    head.printLinkList()
}

fun deleteNode(node: ListNode?) {
    if (node?.next == null)
        return

    node.`val` = node.next!!.`val`
    node.next = node.next?.next
}