package top.abosen.leetcode;

//[223] 矩形面积
public class RectangleArea {
    public static void main(String[] args) {
        Solution solution = new RectangleArea().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
            int a1 = (ax2 - ax1) * (ay2 - ay1);
            int a2 = (bx2 - bx1) * (by2 - by1);
            int ox = Math.min(bx2, ax2) - Math.max(bx1, ax1);
            int oy = Math.min(by2, ay2) - Math.max(by1, ay1);
            int ao = (ox <= 0 || oy <= 0) ? 0 : ox * oy;
            return a1 + a2 - ao;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}