package utils

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun createLinkList(arr: IntArray): ListNode? {
    var head: ListNode? = null
    var ptr: ListNode? = null
    arr.forEach {
        val node = ListNode(it)
        ptr?.next = node
        ptr = node
        if (head == null) head = ptr
    }
    return head
}

fun ListNode?.printLinkList() {
    var head = this
    while (head != null) {
        print("${head.`val`} ")
        head = head.next
    }
}