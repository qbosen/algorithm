package top.abosen.leetcode;

import java.util.*;
import top.abosen.leetcode.struct.*;

//[488] 祖玛游戏
/* "WRRBBW","RB" */
public class ZumaGame{
    public static void main(String[] args) {
        Solution solution = new ZumaGame().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // 手中最多只有5个球，所以，操作次数不会多于5
    int INF = 6;

    public int findMinStep(String board, String hand) {
        // 记忆化缓存
        Map<String, Integer> memo = new HashMap<>();
        // 递归开始
        int ans = dfs(board, hand.toCharArray(), memo);
        // 判断结果
        return ans >= INF ? -1 : ans;
    }

    private int dfs(String board, char[] hand, Map<String, Integer> memo) {
        // 如果board全部消除完了，直接返回
        if (board.length() == 0) {
            return 0;
        }

        // 如果缓存中已经处理过了，直接返回
        if (memo.containsKey(board)) {
            return memo.get(board);
        }

        // 存储本次递归的结果
        int ans = INF;

        // 将手中的球填序的board的任意位置尝试去消除
        for (int i = 0; i < hand.length; i++) {
            char c = hand[i];
            if (c != '0') {
                for (int j = 0; j < board.length(); j++) {
                    // 构造新的board，插入到旧board的任意位置
                    StringBuilder newBoard = new StringBuilder()
                            .append(board.substring(0, j))
                            .append(c)
                            .append(board.substring(j));
                    // 尝试消除
                    removeSame(newBoard, j);
                    // 表示这个球已经用过了
                    hand[i] = '0';
                    // 进入下一次递归
                    ans = Math.min(ans, dfs(newBoard.toString(), hand, memo) + 1);
                    // 回溯，恢复状态
                    hand[i] = c;
                }
            }
        }

        // 记录到缓存中
        memo.put(board, ans);
        // 返回结果
        return ans;
    }

    private void removeSame(StringBuilder board, int index) {
        // 移除三个以上连续的
        if (index < 0 ) {
            return;
        }
        // 从index的位置向两边扩散
        int left = index, right = index;
        char c = board.charAt(index);
        // 注意这里的操作
        while (--left >= 0 && board.charAt(left) == c) ;
        while (++right < board.length() && board.charAt(right) == c) ;

        // 扩散完了两边的right和left位置的值都是不等于 c 的，需要减一表示 c 出现的次数
        int count = right - left - 1;
        // 大于等于3才消除
        if (count >= 3) {
            board.delete(left + 1, right);
            // 连锁反应，比如 YYGGGY，移除了中间的G，三个Y挨一块了，也要移除
            removeSame(board, left);
        }
    }
}

//leetcode submit region end(Prohibit modification and deletion)

}