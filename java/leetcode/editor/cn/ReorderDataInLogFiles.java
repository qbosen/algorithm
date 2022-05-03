package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.cn.struct.*;

//[937] 重新排列日志文件
/* ["dig1,8,1,5,1","let1,art,can","dig2,3,6","let2,own,kit,dig","let3,art,zero"] */
public class ReorderDataInLogFiles {
    public static void main(String[] args) {
        Solution solution = new ReorderDataInLogFiles().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[] reorderLogFiles(String[] logs) {
            List<String> letter = new ArrayList<>();
            List<String> digit = new ArrayList<>();
            for (String log : logs) {
                if (Character.isDigit(log.charAt(log.length() - 1))) {
                    digit.add(log);
                } else {
                    letter.add(log);
                }
            }
            letter.sort((o1, o2) -> {
                String[] split1 = o1.split(" ", 2);
                String[] split2 = o2.split(" ", 2);
                int cmp = split1[1].compareTo(split2[1]);
                if (cmp == 0) {
                    return split1[0].compareTo(split2[0]);
                }
                return cmp;
            });
            letter.addAll(digit);
            return letter.toArray(new String[0]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}