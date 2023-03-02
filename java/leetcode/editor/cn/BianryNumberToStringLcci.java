package leetcode.editor.cn;
		  
import java.util.*;
import leetcode.editor.cn.struct.*;
		  
//[面试题 05.02] 二进制数转字符串
/* 0.625 */
public class BianryNumberToStringLcci{
    public static void main(String[] args) {
        Solution solution = new BianryNumberToStringLcci().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String printBin(double num) {
        StringBuilder sb = new StringBuilder("0.");
        while (sb.length() <= 32 && num != 0) {
            num *= 2;
            int digit = (int) num;
            sb.append(digit);
            num -= digit;
        }
        return sb.length() <= 32 ? sb.toString() : "ERROR";
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}