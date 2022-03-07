package leetcode.editor.cn;
		  
import java.util.*;
import leetcode.editor.cn.struct.*;
		  
//[504] 七进制数
/* 100 */
public class Base7{
    public static void main(String[] args) {
        Solution solution = new Base7().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String convertToBase7(int num) {
        if(num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        boolean negative = false;
        if (num < 0) {
            negative = true;
            num = -num;
        }

        while (num != 0) {
            int remainder = num % 7;
            num = num / 7;
            sb.append(remainder);
        }
        if (negative) {
            sb.append('-');
        }
        return sb.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}