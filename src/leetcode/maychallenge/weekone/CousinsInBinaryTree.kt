package leetcode.maychallenge.weekone

import utils.TreeNode
import java.util.*

fun main() {

}

fun isCousins(root: TreeNode?, x: Int, y: Int): Boolean {
    val list1 = LinkedList<Int>()
    val list2 = LinkedList<Int>()

    getDepthPath(root, x, list1)
    getDepthPath(root, y, list2)

    list1.pollLast()
    list2.pollLast()
    list2.forEach { print(" $it") }
    println()
    list1.forEach { print(" $it") }

    return list1.size == list2.size && list1.peekLast() != list2.peekLast()

}

fun getDepthPath(root: TreeNode?, value: Int, depth: LinkedList<Int>) {
    if (root == null || depth.peekLast() == value)
        return

    depth.add(root.`val`)

    if (root.`val` == value) {
        return
    }

    getDepthPath(root.left, value, depth)
    getDepthPath(root.right, value, depth)
    if (depth.peekLast() != value)
        depth.pollLast()
}