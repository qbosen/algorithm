package leetcode.editor.cn;

//[1450] 在既定时间做作业的学生人数
/* [1,2,3],[3,2,7],4 */
public class NumberOfStudentsDoingHomeworkAtAGivenTime {
    public static void main(String[] args) {
        Solution solution = new NumberOfStudentsDoingHomeworkAtAGivenTime().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
            int res = 0;
            for (int i = 0; i < startTime.length; i++) {
                if (queryTime >= startTime[i] && queryTime <= endTime[i]) {
                    res++;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}