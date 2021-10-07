package top.abosen.leetcode;
		  
import java.util.*;
import top.abosen.leetcode.struct.*;
		  
//[434] 字符串中的单词数
/* "Hello,,my,name,is,John" */
public class NumberOfSegmentsInAString{
    public static void main(String[] args) {
        Solution solution = new NumberOfSegmentsInAString().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countSegments(String s) {
        boolean word = false;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == ' '){
                word = false;
            }else{
                if(!word){
                    count++;
                    word = true;
                }
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}