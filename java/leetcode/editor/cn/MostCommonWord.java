package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.cn.struct.*;

//[819] 最常见的单词
/* "Bob,hit,a,ball,,the,hit,BALL,flew,far,after,it,was,hit.",["hit"] */
public class MostCommonWord {
    public static void main(String[] args) {
        Solution solution = new MostCommonWord().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String mostCommonWord(String s, String[] banned) {
            Set<String> set = new HashSet<>();
            Collections.addAll(set, banned);
            char[] cs = s.toCharArray();
            int n = cs.length;
            Map<String, Integer> map = new HashMap<>();
            String res = "";
            map.put(res, 0);
            for (int i = 0; i < n; ) {
                if (!Character.isLetter(cs[i])) {
                    ++i;
                    continue;
                }
                int j = i;
                while (j < n && Character.isLetter(cs[j])) {
                    j++;
                }
                String str = s.substring(i, j).toLowerCase();
                i = j + 1;
                if (set.contains(str)) {
                    continue;
                }
                map.compute(str, (k, v) -> v == null ? 1 : v + 1);
                if (map.get(str) > map.get(res)) res = str;

            }
            return res;
        }
    }


//leetcode submit region end(Prohibit modification and deletion)

}