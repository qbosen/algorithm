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
        node.findNode(-1) ?: println("not found!!")
    }

    @Test
    fun toIndexValUndirectedGraphTest() {
        val node = "[[2,4],[1,3],[2,4],[1,3]]".toIndexValUndirectedGraph()
        node.print()
    }

    @Test
    fun test2DStringList() {
        println("""[["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]""".to2DStringList())
    }

    @Test
    fun `测试null压缩的层序二叉树构建`() {
        val testCase = listOf(
                "[1,2,null,null,3,4]",
                "[]","[null]",
                "[1,2,3,null,5,null,4]",
                "[3,1,4,null,null,2]",
                "[3,1,null,null,2]",
                "[5,3,6,2,4,null,null,1]",
                "[1,null,2,null,3,4,5]",
                "[1,null,2,null,3,4,5,6]",
                "[0,0,null,0,null,0,null,null,0]",
        )
        testCase.forEach { it.toTreeNode2()?.print() }
    }
}