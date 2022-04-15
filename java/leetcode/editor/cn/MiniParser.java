package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.cn.struct.*;

//[385] 迷你语法分析器
/* "324" */
public class MiniParser {
    public static void main(String[] args) {
        Solution solution = new MiniParser().new Solution();
        System.out.println(solution.deserialize("324"));
        System.out.println(solution.deserialize("[123,[456,[789]]]"));
    }

    public class NestedInteger {
        // Constructor initializes an empty nested list.
        int value;
        List<NestedInteger> list;

        public NestedInteger() {
        }

        // Constructor initializes a single integer.
        public NestedInteger(int value) {
            this.value = value;
        }

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger() {
            return list == null;
        }

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger() {
            return value;
        }

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value) {
            this.value = value;
        }

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni) {
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(ni);
        }

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList() {
            return list;
        }

        @Override
        public String toString() {
            return isInteger() ? value + "" : list.toString();
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public NestedInteger deserialize(String s) {
            var stack = new LinkedList<NestedInteger>();
            var dummy = new NestedInteger();
            stack.push(dummy);

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '[') {
                    stack.push(new NestedInteger());
                } else if (c == ']') {
                    var ni = stack.pop();
                    stack.peek().add(ni);
                } else if (c == ',') {
                    continue;
                } else {
                    var num = 0;
                    var sign = 1;
                    if (c == '-') {
                        sign = -1;
                        i++;
                    }
                    while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                        num = num * 10 + (s.charAt(i) - '0');
                        i++;
                    }
                    stack.peek().add(new NestedInteger(num * sign));
                    i--;
                }
            }
            return dummy.getList().get(0);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}