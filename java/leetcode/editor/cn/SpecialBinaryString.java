package leetcode.editor.cn;
		  
import java.util.*;
import leetcode.editor.cn.struct.*;
		  
//[761] 特殊的二进制序列
/* "11011000" */
public class SpecialBinaryString{
    public static void main(String[] args) {
        Solution solution = new SpecialBinaryString().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String makeLargestSpecial(String s) {
        return dfs(s, 0, s.length() - 1);
    }

    private String dfs(String s, int start, int end) {
        if (end < start) {
            return "";
        }

        List<String> list = new ArrayList<>();
        int count = 0, pre = start;
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) == '1') {
                count++;
            } else {
                count--;
                if (count == 0) {
                    // 对子串做相同的操作
                    list.add("1" + dfs(s, pre + 1, i - 1) + "0");
                    pre = i + 1;
                }
            }
        }

        list.sort(Comparator.reverseOrder());

        return String.join("", list);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}