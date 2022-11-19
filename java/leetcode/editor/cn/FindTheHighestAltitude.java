package leetcode.editor.cn;

//[1732] 找到最高海拔
/* [-5,1,5,0,-7] */
public class FindTheHighestAltitude {
    public static void main(String[] args) {
        Solution solution = new FindTheHighestAltitude().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largestAltitude(int[] gain) {
            int altitude = 0, res = 0;
            for (int g : gain) {
                altitude += g;
                res = Math.max(res, altitude);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}