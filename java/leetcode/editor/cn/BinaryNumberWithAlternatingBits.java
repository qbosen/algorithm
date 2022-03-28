package leetcode.editor.cn;
		  
import java.util.*;
import leetcode.editor.cn.struct.*;
		  
//[693] 交替位二进制数
/* 5 */
public class BinaryNumberWithAlternatingBits{
    public static void main(String[] args) {
        Solution solution = new BinaryNumberWithAlternatingBits().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean hasAlternatingBits(int n) {
        int a =(n >>> 1) ^ n;
        return (a & a + 1) == 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}