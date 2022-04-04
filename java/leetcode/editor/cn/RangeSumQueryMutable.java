package leetcode.editor.cn;

//[307] 区域和检索 - 数组可修改
/* ["NumArray","sumRange","update","sumRange"],[[[1,3,5]],[0,2],[1,2],[0,2]] */
public class RangeSumQueryMutable {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class NumArray {
        int[] tree;
        int[] nums;
        int n;

        int lowBit(int x) {
            return x & -x;
        }

        int query(int x) {
            int ans = 0;
            for (int i = x; i > 0; i -= lowBit(i)) {
                ans += tree[i];
            }
            return ans;
        }

        void add(int x, int u) {
            for (int i = x; i <= n; i += lowBit(i)){
                tree[i] += u;
            }
        }

        public NumArray(int[] nums) {
            this.nums = nums;
            n = this.nums.length;
            tree = new int[n + 1];
            for (int i = 0; i < n; i++){
                add(i + 1, this.nums[i]);
            }

        }

        public void update(int i, int val) {
            add(i + 1, val - nums[i]);
            nums[i] = val;
        }

        public int sumRange(int l, int r) {
            return query(r + 1) - query(l);
        }
    }
/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
//leetcode submit region end(Prohibit modification and deletion)

}