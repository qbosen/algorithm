package leetcode.editor.cn
import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import util.to2DIntArray

// 463 岛屿的周长
/* [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]] */

fun main() {
    val result = IslandPerimeter.Solution()::islandPerimeter
    assertThat(result("[[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]".to2DIntArray()), equalTo( 16))
}

class IslandPerimeter{
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun islandPerimeter(grid: Array<IntArray>): Int {
        if(grid.isEmpty() || grid[0].isEmpty()) return 0
        var isolate = 0
        for(i in grid.indices){
            var prevOne = false
            for(j in grid[0].indices){
                if(!prevOne && grid[i][j]==1){
                    prevOne = true
                    isolate++
                }else if(prevOne && grid[i][j]==0){
                    prevOne = false
                }
            }
        }

        for(j in grid[0].indices){
            var prevOne = false
            for(i in grid.indices){
                if(!prevOne && grid[i][j]==1){
                    prevOne = true
                    isolate++
                }else if(prevOne && grid[i][j]==0){
                    prevOne = false
                }
            }
        }
        return isolate * 2
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}