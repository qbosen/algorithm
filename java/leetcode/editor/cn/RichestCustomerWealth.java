package leetcode.editor.cn;

//[1672] 最富有客户的资产总量
/* [[1,2,3],[3,2,1]] */
public class RichestCustomerWealth {
    public static void main(String[] args) {
        Solution solution = new RichestCustomerWealth().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumWealth(int[][] accounts) {
            int res = 0;
            for (int[] account : accounts) {
                int asset = 0;
                for (int money : account) {
                    asset += money;
                }
                if (asset > res) res = asset;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}