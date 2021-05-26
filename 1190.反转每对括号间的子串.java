import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=1190 lang=java
 *
 * [1190] 反转每对括号间的子串
 */

// @lc code=start
class Solution {
    public String reverseParentheses(String s) {
        int n = s.length();
        int[] pair = new int[n];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                int j = stack.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }

        StringBuffer sb = new StringBuffer();
        int idx = 0, step = 1;
        while(idx < n){
            if(s.charAt(idx) == '(' || s.charAt(idx) == ')'){
                // reverse direction
                idx = pair[idx];
                step = -step;
            }else{
                sb.append(s.charAt(idx));
            }
            idx += step;
        }
        return sb.toString();
    }
}
// @lc code=end
