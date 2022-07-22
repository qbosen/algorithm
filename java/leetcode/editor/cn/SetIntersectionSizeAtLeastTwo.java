package leetcode.editor.cn;

import java.util.Arrays;

//[757] 设置交集大小至少为2
/* [[1,3],[1,4],[2,5],[3,5]] */
public class SetIntersectionSizeAtLeastTwo {
    public static void main(String[] args) {
        Solution solution = new SetIntersectionSizeAtLeastTwo().new Solution();
        System.out.println(solution.intersectionSizeTwo(new int[][]{{1, 3}, {1, 4}, {2, 5}, {3, 5}}));
        System.out.println(solution.intersectionSizeTwo(new int[][]{{1, 2}, {2, 3}, {2, 4}, {5, 5}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int intersectionSizeTwo(int[][] intervals) {
            Arrays.sort(intervals, (a, b) -> a[1] != b[1] ? a[1] - b[1] : b[0] - a[0]);
            // a,b 是 集合中最后两个交点元素 (也是最大的两个元素)
            int a = -1, b = -1, ans = 0;
            for (int[] i : intervals) {
                if (i[0] > b) {                 // 新的区间,取两个点
                    a = i[1] - 1;
                    b = i[1];
                    ans += 2;
                } else if (i[0] > a) {          // 只有一个点重叠,补一个点
                    a = b;
                    b = i[1];
                    ans++;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}