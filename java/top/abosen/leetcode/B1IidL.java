package top.abosen.leetcode;

//[剑指 Offer II 069] 山峰数组的顶部
/* [0,1,0] */
public class B1IidL {
    public static void main(String[] args) {
        Solution solution = new B1IidL().new Solution();
        System.out.println(solution.peakIndexInMountainArray(new int[]{3, 5, 3, 2, 0}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int peakIndexInMountainArray(int[] arr) {
            int l = 0, r = arr.length - 1;
            while (l < r) {
                int m = (l + r) / 2;
                if (m == 0) {
                    return 1;
                } else if (arr[m] > arr[m - 1]) {
                    if (arr[m] > arr[m + 1]) {
                        return m;
                    }
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            return l;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}