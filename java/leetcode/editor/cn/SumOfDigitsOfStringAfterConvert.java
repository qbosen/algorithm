package leetcode.editor.cn;
		  
import java.util.*;
import leetcode.editor.cn.struct.*;
		  
//[1945] 字符串转化后的各位数字之和
/* "iiii",1 */
public class SumOfDigitsOfStringAfterConvert{
    public static void main(String[] args) {
        Solution solution = new SumOfDigitsOfStringAfterConvert().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            sb.append(ch - 'a' + 1);
        }
        String digits = sb.toString();
        for (int i = 1; i <= k && digits.length() > 1; ++i) {
            int sum = 0;
            for (int j = 0; j < digits.length(); ++j) {
                char ch = digits.charAt(j);
                sum += ch - '0';
            }
            digits = Integer.toString(sum);
        }

        return Integer.parseInt(digits);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}