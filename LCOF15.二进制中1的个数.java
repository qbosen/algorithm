// @algorithm @lc id=100292 lang=java 
// @title er-jin-zhi-zhong-1de-ge-shu-lcof

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n = (n & (n - 1));
            count++;
        }
        return count;
    }
}