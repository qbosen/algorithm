package top.abosen.leetcode;

//[319] 灯泡开关
/* 3 */
public class BulbSwitcher {
    public static void main(String[] args) {
        Solution solution = new BulbSwitcher().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int bulbSwitch(int n) {
            return (int) Math.sqrt(n + 0.5);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}