package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

//[1697] 检查边长度限制的路径是否存在
/* 3,[[0,1,2],[1,2,4],[2,0,8],[1,0,16]],[[0,1,2],[0,2,5]] */
public class CheckingExistenceOfEdgeLengthLimitedPaths {
    public static void main(String[] args) {
        Solution solution = new CheckingExistenceOfEdgeLengthLimitedPaths().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
            // edge sort by distance
            Arrays.sort(edgeList, Comparator.comparingInt(a -> a[2]));
            // query sort by limit; maintain the query order
            Integer[] index = new Integer[queries.length];
            for (int i = 0; i < index.length; i++) {
                index[i] = i;
            }
            Arrays.sort(index, Comparator.comparingInt(a -> queries[a][2]));

            int[] uf = new int[n];
            for (int i = 0; i < n; i++) {
                uf[i] = i;
            }

            boolean[] res = new boolean[queries.length];
            // minimal edge not satisfy limit query
            int k = 0;
            for (int i : index) {
                while (k < edgeList.length && edgeList[k][2] < queries[i][2]) {
                    union(uf, edgeList[k][0], edgeList[k][1]);
                    k++;
                }
                res[i] = find(uf, queries[i][0]) == find(uf, queries[i][1]);
            }

            return res;
        }

        int find(int[] uf, int t) {
            return uf[t] == t ? t : find(uf, uf[t]);
        }

        void union(int[] uf, int x, int y) {
            int ancestorX = find(uf, x);
            int ancestorY = find(uf, y);
            uf[ancestorY] = ancestorX;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}