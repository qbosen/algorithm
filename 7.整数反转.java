/*
 * @lc app=leetcode.cn id=7 lang=java
 *
 * [7] 整数反转
 */

// @lc code=start
class Solution {
    public int reverse(int x) {
        int rev = 0;
        int high = Integer.MAX_VALUE / 10;
        int low = Integer.MIN_VALUE / 10;
        while (x !=0 ){
            if(rev < low || rev > high){
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            rev = rev * 10 + digit;
        }
        return rev;
    }
}
// @lc code=end
