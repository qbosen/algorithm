package leetcode.editor.cn;

//[754] 到达终点数字
/* 2 */
public class ReachANumber {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reachNumber(int target) {
            target = Math.abs(target);
            int k = 0;
            while (target > 0) {
                k++;
                target -= k;
            }

            return target % 2 == 0 ? k : k + 1 + k % 2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}