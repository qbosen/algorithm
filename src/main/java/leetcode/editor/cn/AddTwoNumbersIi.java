package leetcode.editor.cn;
// 两数相加 II
// 445
// [7,2,4,3], [5,6,4]

import struct.ListNode;
import util.IntUtil;

import java.util.Stack;

public class AddTwoNumbersIi {
    public static void run(Solution solution, String expect, String l1, String l2) {
        ListNode l1_ = IntUtil.parse1DInt2ListNode(l1);
        ListNode l2_ = IntUtil.parse1DInt2ListNode(l2);
        ListNode result = solution.addTwoNumbers(l1_, l2_);
        System.out.println(expect + "=" + result);
    }

    public static void main(String[] args) {
        Solution solution = new AddTwoNumbersIi().new Solution();
        run(solution, "[7,8,0,7]", "[7,2,4,3]", "[5,6,4]");
        run(solution, "[7,2,4,3]", "[7,2,4,3]", "[0]");
        run(solution, "[2,0,1,1]", "[1,2]", "[1,9,9,9]");
        run(solution, "[1,0]", "[5]", "[5]");
    }

//leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            Stack<Integer> s1 = toStack(l1);
            Stack<Integer> s2 = toStack(l2);
            ListNode downNode = null;
            int carry = 0;
            while (!s1.empty() && !s2.empty()) {
                int sum = s1.pop() + s2.pop() + carry;
                if (sum > 9) {
                    carry = 1;
                    sum -= 10;
                } else {
                    carry = 0;
                }
                ListNode node = new ListNode(sum);
                node.next = downNode;
                downNode = node;
            }
            while (!s1.empty()) {
                int sum = s1.pop() + carry;
                if (sum > 9) {
                    carry = 1;
                    sum -= 10;
                } else {
                    carry = 0;
                }
                ListNode node = new ListNode(sum);
                node.next = downNode;
                downNode = node;
            }
            while (!s2.empty()) {
                int sum = s2.pop() + carry;
                if (sum > 9) {
                    carry = 1;
                    sum -= 10;
                } else {
                    carry = 0;
                }
                ListNode node = new ListNode(sum);
                node.next = downNode;
                downNode = node;
            }
            if (carry == 1) {
                ListNode node = new ListNode(1);
                node.next = downNode;
                return node;
            }
            return downNode;
        }

        private Stack<Integer> toStack(ListNode node) {
            Stack<Integer> stack = new Stack<>();
            while (node != null) {
                stack.push(node.val);
                node = node.next;
            }
            return stack;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}