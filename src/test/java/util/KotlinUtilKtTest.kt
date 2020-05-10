package util

import org.junit.Test


/**
 * @author qiubaisen
 * @date 2020/5/10
 */
internal class KotlinUtilKtTest {

    @Test
    fun findNode() {
        val node = "[3,5,1,6,2,0,8,null,null,7,4]".toTreeNode()
        node.findNode(3)!!.print()
        node.findNode(1)!!.print()
        node.findNode(5)!!.print()
        node.findNode(-1)?: println("not found!!")
    }
}