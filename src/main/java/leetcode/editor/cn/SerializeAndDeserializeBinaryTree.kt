package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import struct.TreeNode
import java.util.*


// 二叉树的序列化与反序列化
// 297
/* [1,2,3,null,null,4,5] */

fun main() {
    val codec = SerializeAndDeserializeBinaryTree.Codec()
    val test:(String)->Unit = { str -> assertThat(str, equalTo(codec.serialize(codec.deserialize(str)))) }
    test("[1,2,3,null,null,4,5]")
    test("[]")
}

class SerializeAndDeserializeBinaryTree {
//leetcode submit region begin(Prohibit modification and deletion)


    class Codec() {
        // Encodes a URL to a shortened URL.
        fun serialize(root: TreeNode?): String {
            if (root == null) return "[]"
            val res = StringBuilder("[")
            val queue: Queue<TreeNode?> = LinkedList()
            queue.add(root)
            while (!queue.isEmpty()) {
                val cur = queue.remove()
                if (cur == null) {
                    if (queue.asSequence().all { it == null }) {
                        break
                    } else {
                        res.append("null,")
                    }
                } else {
                    res.append(cur.`val`).append(",")
                    queue.add(cur.left)
                    queue.add(cur.right)
                }
            }
            res.setLength(res.length - 1)
            res.append("]")
            return res.toString()
        }

        //    // Decodes your encoded data to tree.
        fun deserialize(data: String): TreeNode? {
            if (data.length == 2) return null
            val nodes = data.substring(1, data.length - 1).split(",").toTypedArray()
            val root = getNode(nodes[0])
            val parents: Queue<TreeNode?> = LinkedList()
            var parent = root
            var isLeft = true
            for (i in 1 until nodes.size) {
                val cur = getNode(nodes[i])
                if (isLeft) {
                    parent!!.left = cur
                } else {
                    parent!!.right = cur
                }
                if (cur != null) {
                    parents.add(cur)
                }
                isLeft = !isLeft
                if (isLeft) {
                    parent = parents.peek()
                    parents.poll()
                }
            }
            return root
        }

        private fun getNode(`val`: String): TreeNode? {
            return if (`val` == "null") {
                null
            } else TreeNode(Integer.valueOf(`val`))
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}