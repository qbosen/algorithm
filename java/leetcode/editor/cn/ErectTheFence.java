package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.cn.struct.*;

//[587] 安装栅栏
/* [[1,1],[2,2],[2,0],[2,4],[3,3],[4,2]] */
public class ErectTheFence {
    public static void main(String[] args) {
        Solution solution = new ErectTheFence().new Solution();
        System.out.println(Arrays.deepToString(solution.outerTrees(new int[][]{{1, 1}, {2, 2}, {2, 0}, {2, 4}, {3, 3}, {4, 2}})));
        System.out.println(Arrays.deepToString(solution.outerTrees(new int[][]{{1, 2}, {2, 2}, {4,2}})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int cross(int[] p, int[] q, int[] r) {
            return (q[0] - p[0]) * (r[1] - p[1]) - (r[0] - p[0]) * (q[1] - p[1]);
        }

        public int[][] outerTrees(int[][] trees) {
            if (trees.length <= 3) {
                return trees;
            }
            Arrays.sort(trees, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
            int n = trees.length;
            // 凸壳点，里面是tree的index
            int[] hull = new int[n * 2];
            int ptr = 0;
            boolean[] used = new boolean[n];

            hull[ptr++] = 0;
            for (int i = 1; i < n; i++) {
                while (ptr > 1 && cross(trees[hull[ptr - 2]], trees[hull[ptr - 1]], trees[i]) < 0) {
                    used[hull[--ptr]] = false;
                }
                used[i] = true;
                hull[ptr++] = i;
            }
            // 下凸壳大小
            int m = ptr;
            for (int i = n - 2; i >= 0; i--) {
                if (!used[i]) {
                    while (ptr > m && cross(trees[hull[ptr - 2]], trees[hull[ptr - 1]], trees[i]) < 0) {
                        used[hull[--ptr]] = false;
                    }
                    used[i] = true;
                    hull[ptr++] = i;
                }
            }
            // 第一个最后一个都是 起点, 删除最后一个
            ptr--;

            int[][] res = new int[ptr][2];
            for (int i = 0; i < ptr; i++) {
                res[i] = trees[hull[i]];
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}