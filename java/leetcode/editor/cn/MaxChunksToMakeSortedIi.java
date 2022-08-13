package leetcode.editor.cn;

import java.util.LinkedList;

//[768] 最多能完成排序的块 II
/* [5,4,3,2,1] */
public class MaxChunksToMakeSortedIi {
    public static void main(String[] args) {
        Solution solution = new MaxChunksToMakeSortedIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxChunksToSorted(int[] arr) {
            LinkedList<Integer> stack = new LinkedList<Integer>();
            for (int num : arr) {
                if (!stack.isEmpty() && num < stack.getLast()) {
                    int head = stack.removeLast();
                    while (!stack.isEmpty() && num < stack.getLast()) stack.removeLast();
                    stack.addLast(head);
                } else stack.addLast(num);
            }
            return stack.size();
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}