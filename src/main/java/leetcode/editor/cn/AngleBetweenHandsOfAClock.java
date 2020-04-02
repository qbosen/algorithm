package leetcode.editor.cn;

// 1344
// 时钟指针的夹角
public class AngleBetweenHandsOfAClock {
    public static void main(String[] args) {
        Solution solution = new AngleBetweenHandsOfAClock().new Solution();
        System.out.println(solution.angleClock(12, 30) + "=165");
        System.out.println(solution.angleClock(3, 15) + "=7.5");
        System.out.println(solution.angleClock(3, 30) + "=75");
        System.out.println(solution.angleClock(4, 50) + "=155");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double angleClock(int hour, int minutes) {
            double h = hour * 5 + minutes / 12.0;
            double d = h - minutes;
            if (d < 0) d = 60 + d;
            else if (d > 60) d = d - 60;

            if (d > 30) d = 60 - d;

            return d * 6;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}