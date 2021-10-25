package top.abosen.leetcode;

//[2040] 两个有序数组的第 K 小乘积
/* [2,5],[3,4],2 */
public class KthSmallestProductOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new KthSmallestProductOfTwoSortedArrays().new Solution();
        System.out.println(solution.kthSmallestProduct(new int[]{2, 5}, new int[]{3, 4}, 2));
        System.out.println(solution.kthSmallestProduct(new int[]{-4, -2, 0, 3}, new int[]{2, 4}, 6));
        System.out.println(solution.kthSmallestProduct(new int[]{-2, -1, 0, 1, 2}, new int[]{-3, -1, 2, 4, 5}, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
            if (nums1.length > nums2.length) {
                return kthSmallestProduct(nums2, nums1, k);
            }
            long l = -10_000_000_000L, r = 10_000_000_000L;
            while (l < r) {
                long m = l + (r - l) / 2;
                long count = countLessOrEqualProduct(nums1, nums2, m);
                if (count < k) {
                    l = m + 1;
                } else {
                    // 多个乘积相同值时，不存在严格关系，所以m>k时，m也可能时解
                    r = m;
                }
            }
            return l;
        }

        private long countLessOrEqualProduct(int[] nums1, int[] nums2, long product) {
            long count = 0;
            for (int i : nums1) {
                if (i < 0) {
                    // i * j <= p; j >= upper(p/i); idx(j)..len(nums2)-1, count len(nums2)-idx(upper(p/i))
                    long j = (long) Math.ceil((double) product / i);
                    int index = upper(nums2, j);
                    count += nums2.length - index;
                } else if (i > 0) {
                    // i * j <=p; j<=lower(p/i); 0..res; count: res+1
                    long j = (long) Math.floor((double) product / i);
                    int index = lower(nums2, j);
                    count += index + 1;
                } else {
                    // i==0, product>=0时，所有的nums2都成立
                    count += product >= 0 ? nums2.length : 0;
                }
            }
            return count;
        }


        // 第一大于等于的
        private int upper(int[] nums, long value) {
            int l = 0, r = nums.length - 1;
            while (l <= r) {
                int m = l + (r - l) / 2;
                if (nums[m] >= value) {
                    if ((m == 0) || (nums[m - 1] < value)) {
                        return m;
                    }
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
            // 没有找到就返回元素长度，与外部逻辑一致
            return nums.length;
        }

        // 最后一个小于等于的
        private int lower(int[] nums, long value) {
            int l = 0, r = nums.length - 1;
            while (l <= r) {
                int m = l + (r - l) / 2;
                if (nums[m] > value) {
                    r = m - 1;
                } else if (nums[m] <= value) {
                    if (m == nums.length - 1 || nums[m + 1] > value) {
                        return m;
                    }
                    l = m + 1;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}