package leetcode.editor.cn
//1052 爱生气的书店老板
/* [1,0,1,2,1,1,7,5],[0,1,0,1,0,1,0,1],3 */


class GrumpyBookstoreOwner {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun maxSatisfied(customers: IntArray, grumpy: IntArray, X: Int): Int {
            var addition = 0
            var minSatisfied = 0
            // 只计算生气的
            var maxSatisfied = 0

            for (i in 0 until X) {
                if (grumpy[i] == 0) {
                    minSatisfied += customers[i]
                } else {
                    addition += customers[i]
                    maxSatisfied += customers[i]
                }
            }

            for (i in X until customers.size) {
                if (grumpy[i] == 0) minSatisfied += customers[i]
                else addition += customers[i]
                if (grumpy[i - X] == 1) addition -= customers[i - X]
                maxSatisfied = Math.max(maxSatisfied, addition)
            }

            return maxSatisfied + minSatisfied
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}