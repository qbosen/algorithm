package top.abosen.leetcode;

//[1154] 一年中的第几天
/* "2019-01-09" */
public class DayOfTheYear {
    public static void main(String[] args) {
        Solution solution = new DayOfTheYear().new Solution();
        System.out.println(solution.dayOfYear("2019-01-09"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int dayOfYear(String date) {
            int idx = 0;
            int value = 0;
            int[] parse = new int[3];
            for (int i = 0; i < date.length(); i++) {
                char c = date.charAt(i);
                if (c == '-') {
                    parse[idx] = value;
                    idx++;
                    value = 0;
                } else {
                    value = value * 10 + (c - '0');
                }
            }
            parse[idx] = value;
            int year = parse[0];
            boolean isLeap = year % 400 == 0 || (year % 100 != 0 && year % 4 == 0);
            int[] months = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            for (int i = 1; i < months.length; i++) {
                months[i] = months[i] + months[i - 1];
            }
            int month = parse[1];
            return (isLeap && month > 2 ? 1 : 0) + (month == 1 ? 0 : months[month - 2]) + parse[2];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}