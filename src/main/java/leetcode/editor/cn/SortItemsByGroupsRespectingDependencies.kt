package leetcode.editor.cn

import org.junit.Assert.assertArrayEquals
import util.to1DIntArray
import util.to2DIntList
import java.util.*
import kotlin.collections.HashMap


//1203 项目管理
/* 8,2,[-1,-1,1,0,0,1,0,-1],[[],[6],[5],[6],[3,6],[],[],[]] */

fun main() {
    val result = SortItemsByGroupsRespectingDependencies.Solution()::sortItems
    assertArrayEquals(
        result(8, 2, "[-1,-1,1,0,0,1,0,-1]".to1DIntArray(), "[[],[6],[5],[6],[3,6],[],[],[]]".to2DIntList()),
        "[6,3,4,5,2,0,7,1]".to1DIntArray()
    )
    assertArrayEquals(
        result(8, 2, "[-1,-1,1,0,0,1,0,-1]".to1DIntArray(), "[[],[6],[5],[6],[3],[],[4],[]]".to2DIntList()),
        "[]".to1DIntArray()
    )
}

class SortItemsByGroupsRespectingDependencies {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun sortItems(n: Int, m: Int, group: IntArray, beforeItems: List<List<Int>>): IntArray? {
            // 第 1 步：数据预处理，给没有归属于一个组的项目编上组号
            var m = m
            for (i in group.indices) {
                if (group[i] == -1) {
                    group[i] = m
                    m++
                }
            }

            // 第 2 步：实例化组和项目的邻接表
            val groupAdj = Array<ArrayList<Int>>(m) { ArrayList() }
            val itemAdj = Array<ArrayList<Int>>(n) { ArrayList() }

            // 第 3 步：建图和统计入度数组
            val groupsIndegree = IntArray(m)
            val itemsIndegree = IntArray(n)
            val len = group.size
            for (i in 0 until len) {
                val currentGroup = group[i]
                for (beforeItem in beforeItems[i]) {
                    val beforeGroup = group[beforeItem]
                    if (beforeGroup != currentGroup) {
                        groupAdj[beforeGroup].add(currentGroup)
                        groupsIndegree[currentGroup]++
                    }
                }
            }
            for (i in 0 until n) {
                for (item in beforeItems[i]) {
                    itemAdj[item].add(i)
                    itemsIndegree[i]++
                }
            }

            // 第 4 步：得到组和项目的拓扑排序结果
            val groupsList = topologicalSort(groupAdj, groupsIndegree, m)
            if (groupsList.isEmpty()) {
                return IntArray(0)
            }
            val itemsList = topologicalSort(itemAdj, itemsIndegree, n)
            if (itemsList.isEmpty()) {
                return IntArray(0)
            }

            // 第 5 步：根据项目的拓扑排序结果，项目到组的多对一关系，建立组到项目的一对多关系
            // key：组，value：在同一组的项目列表
            val groups2Items: MutableMap<Int, MutableList<Int>> = HashMap()
            itemsList.forEach { groups2Items.computeIfAbsent(group[it]) { ArrayList() }.add(it) }

            // 第 6 步：把组的拓扑排序结果替换成为项目的拓扑排序结果
            val res: MutableList<Int> = ArrayList()
            groupsList.forEach {res.addAll( groups2Items.getOrDefault(it, ArrayList())) }
            return res.stream().mapToInt { i: Int? -> Integer.valueOf(i!!) }.toArray()
        }

        private fun topologicalSort(adj: Array<ArrayList<Int>>, inDegree: IntArray, n: Int): List<Int> {
            val res = ArrayList<Int>()
            val queue = LinkedList<Int>()
            for (i in 0 until n) {
                if (inDegree[i] == 0) {
                    queue.offer(i)
                }
            }
            while (!queue.isEmpty()) {
                val front = queue.poll()
                res.add(front)
                for (successor in adj[front]) {
                    inDegree[successor]--
                    if (inDegree[successor] == 0) {
                        queue.offer(successor)
                    }
                }
            }
            return if (res.size == n) {
                res
            } else ArrayList()
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}