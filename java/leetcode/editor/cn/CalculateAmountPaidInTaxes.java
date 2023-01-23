package leetcode.editor.cn;

//[2303] 计算应缴税款总额
/* [[3,50],[7,10],[12,25]],10 */
public class CalculateAmountPaidInTaxes {
    public static void main(String[] args) {
        Solution solution = new CalculateAmountPaidInTaxes().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double calculateTax(int[][] brackets, int income) {
            double totalTax = 0;
            int lower = 0;
            for (int[] bracket : brackets) {
                int upper = bracket[0], percent = bracket[1];
                int tax = (Math.min(income, upper) - lower) * percent;
                totalTax += tax;
                if (income <= upper) {
                    break;
                }
                lower = upper;
            }
            return totalTax / 100.0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}