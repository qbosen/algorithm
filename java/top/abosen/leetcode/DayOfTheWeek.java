package top.abosen.leetcode;

import java.util.*;

import top.abosen.leetcode.struct.*;

//[1185] 一周中的第几天
/* 31,8,2019 */
public class DayOfTheWeek {
    public static void main(String[] args) {
        Solution solution = new DayOfTheWeek().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String dayOfTheWeek(int day, int month, int year) {
            String[] week = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
            int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30};
            int days = 365 * (year - 1971) + (year - 1969) / 4;
            for (int i = 0; i < month - 1; ++i) {
                days += monthDays[i];
            }
            if ((year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) && month >= 3) {
                days += 1;
            }
            /* 输入月份中的天数贡献 */
            days += day;
            return week[(days + 3) % 7];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}