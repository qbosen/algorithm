package leetcode.editor.cn;

//[1108] IP 地址无效化
/* "1.1.1.1" */
public class DefangingAnIpAddress {
    public static void main(String[] args) {
        Solution solution = new DefangingAnIpAddress().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String defangIPaddr(String address) {
            int n = address.length();
            var sb = new StringBuilder(n + 6);
            for (int i = 0; i < n; i++) {
                char c = address.charAt(i);
                if (c == '.') {
                    sb.append("[.]");
                } else {
                    sb.append(c);
                }
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}