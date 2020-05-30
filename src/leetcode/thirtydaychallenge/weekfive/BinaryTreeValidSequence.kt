package leetcode.thirtydaychallenge.weekfive


fun main() {

}

fun isValidSequence(root: TreeNode?, arr: IntArray): Boolean {
    var path = ""
    for (num in arr) {
        path += num
    }
    return traverseTree(root, "", path)
}

fun traverseTree(root: TreeNode?, path: String, dest: String): Boolean {
    if (root == null)
        return false
    val mPath = path + root.`val`
    if (mPath == dest && root.left == null && root.right == null)
        return true

    return traverseTree(root.left, mPath, dest) || traverseTree(root.right, mPath, dest)
}