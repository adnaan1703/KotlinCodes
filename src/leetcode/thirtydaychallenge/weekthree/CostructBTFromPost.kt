package leetcode.thirtydaychallenge.weekthree

import utils.TreeNode
import utils.printTree
import java.util.*

fun main() {
    printTree(bstFromPreorder(intArrayOf(8, 5, 1, 7, 10, 12)))
    printTree(bstFromPreorder(intArrayOf(100, 90, 80, 60, 95, 110, 105, 101, 106, 107)))
}

fun bstFromPreorder(preorder: IntArray): TreeNode? {
    val stack: Stack<TreeNode> = Stack()
    var rootNode: TreeNode? = null
    for (itr in preorder) {
        if (stack.isEmpty()) {
            rootNode = TreeNode(itr)
            stack.push(rootNode)
            continue
        }

        if (itr <= stack.peek().`val`) {
            val node = TreeNode(itr)
            stack.peek().left = node
            stack.push(node)
        } else {
            val node = TreeNode(itr)
            var root: TreeNode? = null
            while (stack.isEmpty().not() && stack.peek().`val` < itr) {
                root = stack.pop()
            }

            root?.right = node
            stack.push(node)
        }
    }
    return rootNode
}

