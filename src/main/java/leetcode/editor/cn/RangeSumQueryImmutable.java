package leetcode.editor.cn;

//303 区域和检索 - 数组不可变
/* ["NumArray","sumRange","sumRange","sumRange"],[[[-2,0,3,-5,2,-1]],[0,2],[2,5],[0,5]] */
public class RangeSumQueryImmutable {

    //leetcode submit region begin(Prohibit modification and deletion)
    class NumArray {
        private final int[] prefix;

        public NumArray(int[] nums) {
            this.prefix = new int[nums.length + 1];
            prefix[0] = 0;
            for (int i = 0; i < nums.length; i++) {
                prefix[i + 1] = prefix[i] + nums[i];
            }
        }

        public int sumRange(int i, int j) {
            return prefix[j + 1] - prefix[i];
        }
    }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
//leetcode submit region end(Prohibit modification and deletion)

}