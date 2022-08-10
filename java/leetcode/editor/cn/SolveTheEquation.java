package leetcode.editor.cn;

//[640] 求解方程
/* "x+5-3+x=6+x-2" */
public class SolveTheEquation {
    public static void main(String[] args) {
        Solution solution = new SolveTheEquation().new Solution();
        System.out.println(solution.solveEquation("2x=x"));
        System.out.println(solution.solveEquation("3x=33+22+11"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String solveEquation(String equation) {
            int k = 0, c = 0, n = equation.length();
            char[] s = equation.toCharArray();
            for (int i = 0, op = 1; i < n; ) {
                if (s[i] == '+') {
                    op = 1;
                    i++;
                } else if (s[i] == '-') {
                    op = -1;
                    i++;
                } else if (s[i] == '=') {
                    k *= -1;
                    c *= -1;
                    op = 1;
                    i++;
                } else {
                    int j = i;
                    int num = 0;
                    while (j < n && s[j] != '+' && s[j] != '-' && s[j] != '=' && s[j] != 'x') {
                        num = num * 10 + s[j] - '0';
                        j++;
                    }
                    if (j < n && s[j] == 'x') {
                        k += (i < j ? num : 1) * op;
                        j++;
                    } else {
                        c += num * op;
                    }
                    i = j;
                }
            }
            if (k == 0) {
                return c == 0 ? "Infinite solutions" : "No solution";
            } else {
                return "x=" + (c / -k);
            }
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}