package leetcode.editor.cn;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import leetcode.editor.cn.struct.*;

//[398] 随机数索引
/* ["Solution","pick","pick","pick"],[[[1,2,3,3,3]],[3],[1],[3]] */
public class RandomPickIndex {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] nums;

        public Solution(int[] nums) {
            this.nums = nums;
        }

        public int pick(int target) {
            int res = -1;
            int meet = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    meet++;
                    if (0 == ThreadLocalRandom.current().nextInt(meet)) {
                        res = i;
                    }
                }
            }
            return res;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}