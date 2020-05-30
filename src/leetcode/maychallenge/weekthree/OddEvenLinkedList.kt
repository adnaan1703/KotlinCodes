package leetcode.maychallenge.weekthree

import utils.ListNode
import utils.createLinkList
import utils.printLinkList

fun oddEvenList(h: ListNode?): ListNode? {
    var head = h
    var oddHead: ListNode? = null
    var oddTail: ListNode? = null
    var evenHead: ListNode? = null
    var evenTail: ListNode? = null
    var counter = 0

    while (head != null) {
        if ((++counter) % 2 == 0) {
            evenTail?.next = head
            evenTail = head
            if (evenHead == null) evenHead = evenTail
        } else {
            oddTail?.next = head
            oddTail = head
            if (oddHead == null) oddHead = oddTail
        }
        head = head.next
    }
    evenTail?.next = null
    oddTail?.next = evenHead
    return oddHead
}

fun main() {
    var head = createLinkList(intArrayOf(1, 2, 3, 4, 5))
    head = oddEvenList(head)
    head.printLinkList()
}