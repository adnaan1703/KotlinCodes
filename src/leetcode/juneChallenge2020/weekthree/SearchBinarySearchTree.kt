package leetcode.juneChallenge2020.weekthree

import utils.TreeNode

fun searchBST(root: TreeNode?, `val`: Int): TreeNode? {
    return when {
        root == null -> null
        `val` == root.`val` -> root
        `val` < root.`val` -> searchBST(root.left, `val`)
        else -> searchBST(root.right, `val`)
    }
}