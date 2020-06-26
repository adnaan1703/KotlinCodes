package leetcode.juneChallenge2020.weekfour

import utils.TreeNode

fun sumNumbers(root: TreeNode?): Int {
    return traverseTree(root, 0)
}

fun traverseTree(root: TreeNode?, currentValue: Int): Int {
    if (root == null)
        return 0

    val newValue = currentValue * 10 + root.`val`

    return if (root.left == null && root.right == null) {
        newValue
    } else {
        traverseTree(root.left, newValue) + traverseTree(root.right, newValue)
    }
}
