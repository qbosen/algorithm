package leetcode.editor.cn;
		  
import java.util.*;
import leetcode.editor.cn.struct.*;
		  
//[2309] 兼具大小写的最好英文字母
/* "lEeTcOdE" */
public class GreatestEnglishLetterInUpperAndLowerCase{
    public static void main(String[] args) {
        Solution solution = new GreatestEnglishLetterInUpperAndLowerCase().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String greatestLetter(String s) {
        int[] chars = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = Character.toLowerCase(c) - 'a';
            if (Character.isLowerCase(c)) {
                chars[index] |= 1;
            }else{
                chars[index] |= 2;
            }
        }


        for (int i = chars.length - 1; i >= 0; i--) {
            if(chars[i] == 3){
                return String.valueOf(((char) ('A' + i)));
            }
        }
        return "";
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}