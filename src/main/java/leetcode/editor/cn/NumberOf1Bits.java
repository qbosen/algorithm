package leetcode.editor.cn;
//191 位1的个数
/* 00000000000000000000000000001011 */
public class NumberOf1Bits{

//leetcode submit region begin(Prohibit modification and deletion)
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while(n !=0 ){
            n = n & (n-1);
            count++;
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}