package leetcode.editor.cn

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import util.to2DIntArray

// 课程表
// 207
/* 2,[[1,0]] */

fun main() {
    val result = CourseSchedule.Solution()::canFinish
    assertThat(result(2, "[[1,0]]".to2DIntArray()), equalTo(true))
    assertThat(result(2, "[[1,0],[0,1]]".to2DIntArray()), equalTo(false))
}

class CourseSchedule {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
            val edges = Array(numCourses) { mutableListOf<Int>() }
            prerequisites.forEach { edges[it[0]].add(it[1]) }
            val visited = IntArray(numCourses)
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
            }

            for (i in 0 until numCourses) {
                if (visited[i] == 0) {
                    dfs(i)
                }
                if (invalid) return false
            }

            return true
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}