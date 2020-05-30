package leetcode.aprilChallenge2020.weektwo

import kotlin.math.max

private class TreeNode(val `val`: Int) {
    val left: TreeNode? = null
    val right: TreeNode? = null
}

private fun diameterOfBinaryTree(root: TreeNode?): Int {
    val map: HashMap<TreeNode?, Int> = HashMap()
    if (root == null)
        return 0

    return travelBinaryTree(root, map, Int.MIN_VALUE)
}

private fun travelBinaryTree(root: TreeNode, map: HashMap<TreeNode?, Int>, maxValue: Int): Int {
    var maxx = maxValue
    if (root.left != null) {
        maxx = max(maxx, travelBinaryTree(root.left, map, maxx))
    }

    if (root.right != null) {
        maxx = max(maxx, travelBinaryTree(root.right, map, maxx))
    }

    val leftHeight: Int = map.getOrDefault(root.left, 0)
    val rightHeight: Int = map.getOrDefault(root.right, 0)
    map[root] = max(leftHeight, rightHeight) + 1
    maxx = max(maxx, leftHeight + rightHeight)

    return maxx
}
