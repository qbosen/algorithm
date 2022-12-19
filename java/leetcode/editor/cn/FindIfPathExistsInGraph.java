package leetcode.editor.cn;

//[1971] 寻找图中是否存在路径
/* 3,[[0,1],[1,2],[2,0]],0,2 */
public class FindIfPathExistsInGraph {
    public static void main(String[] args) {
        Solution solution = new FindIfPathExistsInGraph().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validPath(int n, int[][] edges, int source, int destination) {
            int[] uf = new int[n];
            for (int i = 0; i < n; i++) {
                uf[i] = i;
            }
            for (int[] edge : edges) {
                union(uf, edge[0], edge[1]);
            }

            return find(uf, source) == find(uf, destination);
        }

        int find(int[] uf, int t) {
            return uf[t] == t ? t : find(uf, uf[t]);
        }

        void union(int[] uf, int x, int y) {
            int xx = find(uf, x);
            int yy = find(uf, y);
            uf[xx] = yy;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}