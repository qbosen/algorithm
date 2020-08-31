package leetcode.editor.cn
import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.*
import util.to2DIntList

// 841 钥匙和房间
/* [[1],[2],[3],[]] */

fun main() {
    val result = KeysAndRooms.Solution()::canVisitAllRooms
    assertThat(result("[[1],[2],[3],[]]".to2DIntList()), equalTo(true ))
    assertThat(result("[[1,3],[3,0,1],[2],[0]]".to2DIntList()), equalTo(false ))
}

class KeysAndRooms{
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {
        val visited = BooleanArray(rooms.size)
        var visitCount = 0
        fun dfs(room:Int){
            visited[room] = true
            visitCount++
            for (key in rooms[room]) {
                if(!visited[key]){
                    dfs(key)
                }
            }
        }

        dfs( 0)
        return visitCount == rooms.size
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}