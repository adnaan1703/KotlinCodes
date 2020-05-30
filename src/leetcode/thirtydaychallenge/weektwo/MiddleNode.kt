package leetcode.thirtydaychallenge.weektwo

private class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

private fun middleNode(head: ListNode?): ListNode? {
    var slowPtr: ListNode? = head
    var fastPtr: ListNode? = head?.next

    while (fastPtr != null) {
        slowPtr = slowPtr?.next
        fastPtr = fastPtr.next?.next
    }
    return slowPtr
}