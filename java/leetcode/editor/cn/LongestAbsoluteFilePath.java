package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.cn.struct.*;

//[388] 文件的最长绝对路径
/* "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" */
public class LongestAbsoluteFilePath {
    public static void main(String[] args) {
        Solution solution = new LongestAbsoluteFilePath().new Solution();
        System.out.println(solution.lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
        System.out.println(solution.lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));
        System.out.println(solution.lengthLongestPath("a"));
        System.out.println(solution.lengthLongestPath("file1.txt\nfile2.txt\nlongfile.txt"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthLongestPath(String s) {
            int res = 0;
            var deque = new ArrayDeque<Integer>();
            deque.push(-1);

            int i = 0;
            int n = s.length();
            while (i < n) {
                // 计算\t
                int tc = 0;
                while (i < n && s.charAt(i) == '\t') {
                    i++;
                    tc++;
                }
                // 把目录调整到和tc一致
                while (deque.size() > tc + 1) {
                    deque.pop();
                }

                // 路径/文件
                int start = i;
                char cur;
                boolean isFile = false;
                while (i < n && (cur = s.charAt(i)) != '\n') {
                    i++;
                    if (cur == '.') isFile = true;
                }
                // prev path + '/' + current path
                int path = deque.peek() + 1 + i - start;
                if (isFile) {
                    res = Math.max(path, res);
                } else {
                    deque.push(path);
                }

                // 末尾 EOF(i==n) 或者 \n
                i++;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}