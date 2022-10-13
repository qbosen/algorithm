package leetcode.editor.cn;

//[769] 最多能完成排序的块
/* [4,3,2,1,0] */
public class MaxChunksToMakeSorted {
    public static void main(String[] args) {
        Solution solution = new MaxChunksToMakeSorted().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxChunksToSorted(int[] arr) {
            int n = arr.length, res = 0;
            for (int i = 0, j = 0, min = n, max = -1; j < n; j++) {
                min = Math.min(min, arr[j]);
                max = Math.max(max, arr[j]);
                // 此时 区间[i,j]排序后与源数组排序后相同
                if (min == i && max == j) {
                    res++;
                    i = j + 1;
                    min = n;
                    max = -1;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}