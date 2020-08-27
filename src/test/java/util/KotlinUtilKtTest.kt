package util

import org.junit.Test
import struct.Node
import kotlin.streams.toList


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
    fun test2DStringList(){
        println("""[["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]""".to2DStringList())
    }

}