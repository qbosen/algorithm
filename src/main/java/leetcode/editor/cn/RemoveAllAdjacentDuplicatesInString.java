package leetcode.editor.cn;

//1047 删除字符串中的所有相邻重复项
/* "abbaca" */
public class RemoveAllAdjacentDuplicatesInString {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String removeDuplicates(String S) {
            if (S.length() == 1) return S;
            char[] ss = S.toCharArray();
            int index = -1;
            for (char c : ss) {
                if (index != -1 && c == ss[index]) {
                    index--;
                } else {
                    ++index;
                    ss[index] = c;
                }
            }
            return new String(ss, 0, index + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}