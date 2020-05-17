package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.either
import org.hamcrest.Matchers.equalTo
import util.to1DIntArray
import util.to2DIntArray

// 课程表 II
// 210
/* 2,[[1,0]] */

fun main() {
    val result = CourseScheduleIi.Solution()::findOrder
    assertThat(result(2, "[[1,0]]".to2DIntArray()), equalTo("[0,1]".to1DIntArray()))
    assertThat(result(4, "[[1,0],[2,0],[3,1],[3,2]]".to2DIntArray()),
            either(equalTo("[0,1,2,3]".to1DIntArray())).or(equalTo("[0,2,1,3]".to1DIntArray())))
}

class CourseScheduleIi {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
            val edges = Array(numCourses) { mutableListOf<Int>() }
            prerequisites.forEach { edges[it[0]].add(it[1]) }
            val visited = IntArray(numCourses)
            val result = mutableListOf<Int>()
            var invalid = false

            fun dfs(u: Int) {
                visited[u] = 1              // 搜索中
                for (v in edges[u]) {       // 相邻节点
                    when (visited[v]) {
                        0 -> dfs(v)             // 未搜索
                        1 -> invalid = true     // 搜索中，有环
                    }
                    if (invalid) return

                }
                visited[u] = 2              // 搜索完成
                result.add(u)               // 不依赖其他的基础课
            }

            for (i in 0 until numCourses) {
                if (visited[i] == 0) {
                    dfs(i)
                }
                if (invalid) return IntArray(0)
            }

            return result.toIntArray()
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}