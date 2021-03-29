package leetcode.editor.cn;

//190 颠倒二进制位
/* 00000010100101000001111010011100 */
public class ReverseBits {

    //leetcode submit region begin(Prohibit modification and deletion)
    public class Solution {
        // you need treat n as an unsigned value
        private static final int M1 = 0x55555555;
        private static final int M2 = 0x33333333;
        private static final int M4 = 0x0f0f0f0f;
        private static final int M8 = 0x00ff00ff;

        public int reverseBits(int n) {
            n = (n >>> 1 & M1) | ((n & M1) << 1);
            n = (n >>> 2 & M2) | ((n & M2) << 2);
            n = (n >>> 4 & M4) | ((n & M4) << 4);
            n = (n >>> 8 & M8) | ((n & M8) << 8);
            return n >>> 16 | n << 16;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}