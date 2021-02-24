package struct

import org.junit.Assert
import org.junit.Test
import util.print
import util.toTreeNode2

/**
 * @author qiubaisen
 * @date 2020/9/28
 */
class LinkedTreeNodeKtTest{
    @Test
    fun `linkedTreeNode test`(){
        val node = "[1,2,3,4,5,null,7]".toTreeNode2()
        node?.print()
        val t = node.toLinked()
        t?.left?.next= t?.right
        t?.left?.run { left?.next = right }
        t?.left?.right?.next=t?.right?.right
        Assert.assertEquals("[1,#,2,3,#,4,5,7,#]", t.desc())
        println(t.desc())
    }
}