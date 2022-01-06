package top.abosen.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.Collectors;

//[71] 简化路径
/* "/home/" */
public class SimplifyPath {
    public static void main(String[] args) {
        Solution solution = new SimplifyPath().new Solution();
        System.out.println(solution.simplifyPath("/home/"));
        System.out.println(solution.simplifyPath("/../"));
        System.out.println(solution.simplifyPath("/home//foo/"));
        System.out.println(solution.simplifyPath("/a/./b/../../c/"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String simplifyPath(String path) {
            Deque<String> queue = new ArrayDeque<>();
            for (String p : path.split("/")) {
                if (p.length() == 0 || p.equals(".")) {
                    continue;
                } else if (p.equals("..")) {
                    if (!queue.isEmpty()) {
                        queue.removeLast();
                    }
                } else {
                    queue.addLast(p);
                }
            }
            return queue.stream().collect(Collectors.joining("/", "/", ""));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}