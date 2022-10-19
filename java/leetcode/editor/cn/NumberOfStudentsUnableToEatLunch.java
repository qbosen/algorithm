package leetcode.editor.cn;

//[1700] 无法吃午餐的学生数量
/* [1,1,0,0],[0,1,0,1] */
public class NumberOfStudentsUnableToEatLunch {
    public static void main(String[] args) {
        Solution solution = new NumberOfStudentsUnableToEatLunch().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countStudents(int[] students, int[] sandwiches) {
            int i = 0, j = 0, n = students.length, eats = 0;
            // 统计对于同一个三明治 可遍历的学生数
            int remains = n;

            while (true) {
                if (j == n || remains == 0) {
                    return n - eats;
                } else if (i == n) {
                    i = 0;
                } else if (students[i] == sandwiches[j]) {
                    eats++;
                    students[i] = -1;
                    i++;
                    j++;
                    remains = n - eats;
                } else if (students[i] == -1) {
                    i++;
                } else if (students[i] != sandwiches[j]) {
                    i++;
                    remains--;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}