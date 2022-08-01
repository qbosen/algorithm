package leetcode.editor.cn;
		  
import java.util.*;
import leetcode.editor.cn.struct.*;
		  
//[1374] 生成每种字符都是奇数个的字符串
/* 4 */
public class GenerateAStringWithCharactersThatHaveOddCounts{
    public static void main(String[] args) {
        Solution solution = new GenerateAStringWithCharactersThatHaveOddCounts().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String generateTheString(int n) {
        char[] chars = new char[n];
        Arrays.fill(chars, 'a');
        if(n%2==0){
            chars[0] = 'b';
        }
        return new String(chars);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}