package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.cn.struct.*;

//[1020] 飞地的数量
/* [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]] */
public class NumberOfEnclaves {
    public static void main(String[] args) {
        Solution solution = new NumberOfEnclaves().new Solution();
        System.out.println(solution.numEnclaves(new int[][]{{0}, {1}, {1}, {0}, {0}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] uf;

        public int numEnclaves(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            uf = new int[m * n + 1];
            for (int i = 0; i < uf.length; i++) {
                uf[i] = i;
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 0) continue;
                    int idx = i * n + j + 1;
                    if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                        // edge
                        join(0, idx);
                    }
                    if (i + 1 < m && grid[i + 1][j] == 1) {
                        join(idx, idx + n);
                    }
                    if (j + 1 < n && grid[i][j + 1] == 1) {
                        join(idx, idx + 1);
                    }
                }
            }

            int ones = 0, seas = 0;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 0) continue;
                    ones++;
                    if (find(0) == find(i * n + j + 1)) {
                        seas++;
                    }
                }
            }
            return ones - seas;
        }

        private int find(int v) {
            if (uf[v] != v) {
                uf[v] = find(uf[v]);
            }
            return uf[v];
        }

        private void join(int a, int b) {
            uf[find(a)] = find(b);
        }

        private boolean query(int a, int b) {
            return find(a) == find(b);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}