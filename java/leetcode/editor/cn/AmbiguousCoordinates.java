package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//[816] 模糊坐标
/* "(123)" */
public class AmbiguousCoordinates {
    public static void main(String[] args) {
        Solution solution = new AmbiguousCoordinates().new Solution();
        System.out.println(solution.ambiguousCoordinates("(123)"));
        System.out.println(solution.ambiguousCoordinates("(0123)"));
        System.out.println(solution.ambiguousCoordinates("(00011)"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> ambiguousCoordinates(String s) {
            int n = s.length() - 2;
            List<String> res = new ArrayList<>();
            s = s.substring(1, n + 1);
            for (int i = 1; i < n; i++) {
                List<String> left = getPos(s.substring(0, i));
                if (left.isEmpty()) continue;

                List<String> right = getPos(s.substring(i));
                if (right.isEmpty()) continue;

                left.forEach(l -> right.forEach(r -> res.add("(" + l + ", " + r + ")")));
            }
            return res;
        }

        private List<String> getPos(String str) {
            List<String> pos = new ArrayList<>();
            if (str.charAt(0) != '0' || "0".equals(str)) {
                pos.add(str);
            }

            for (int i = 1; i < str.length(); i++) {
                if ((i != 1 && str.charAt(0) == '0') || str.charAt(str.length() - 1) == '0') {
                    continue;
                }
                pos.add(str.substring(0, i) + "." + str.substring(i));
            }

            return pos;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}