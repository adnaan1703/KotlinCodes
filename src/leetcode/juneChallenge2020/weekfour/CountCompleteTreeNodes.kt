package leetcode.juneChallenge2020.weekfour

import utils.TreeNode

/*
 * Notes
 * There are solutions which solves it in O(h^2) where h is the height of the tree
 * If we calculate it comes down to O(n/2) which is nothing but O(n)
 * I just didn't wanted to solve it with unnecessary complications just to gain by constant factor.
 * Hence leaving this solution to plain and simple with O(n)
 */

fun countNodes(root: TreeNode?): Int {
    return when (root) {
        null -> 0
        else -> countNodes(root.left) + countNodes(root.right) + 1
    }
}