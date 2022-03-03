package leetcode.editor.cn;
		  
import java.util.*;
import leetcode.editor.cn.struct.*;
		  
//[258] 各位相加
/* 38 */
public class AddDigits{
    public static void main(String[] args) {
        Solution solution = new AddDigits().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int addDigits(int num) {
        while(num >= 10){
            int next= 0;
            while(num !=0){
                next += num % 10;
                num /= 10;
            }
            num = next;
        }
        return num;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}