package leetcode.juneChallenge2020.weekone

import utils.TreeNode

fun main() {

}

fun invertTree(root: TreeNode?): TreeNode? {
    swapChildren(root)
    return root
}

fun swapChildren(root: TreeNode?) {
    if (root == null)
        return

    val temp = root.left
    root.left = root.right
    root.right = temp

    swapChildren(root.left)
    swapChildren(root.right)
}