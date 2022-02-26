package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

//[537] 复数乘法
/* "1+1i","1+1i" */
public class ComplexNumberMultiplication {
    public static void main(String[] args) {
        Solution solution = new ComplexNumberMultiplication().new Solution();
        System.out.println(solution.complexNumberMultiply("+1+1i", "+1+1i"));
        System.out.println(solution.complexNumberMultiply("-1+-1i", "-1+-1i"));

        for (int x = 0, n = 1000; x < 5; x++, n *= 10) {
            System.out.println("x=" + x + ",n=" + n);
            List<String> data = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                data.add(ThreadLocalRandom.current().nextInt(n) + "+" + ThreadLocalRandom.current().nextInt(n) + 'i');
            }
            long start = System.currentTimeMillis();
            for (int i = 0; i < n; i += 2) {
                solution.complexNumberMultiply(data.get(i), data.get(i + 1));
            }
            System.out.println("1 cost:" + (System.currentTimeMillis() - start));
            start = System.currentTimeMillis();
            for (int i = 0; i < n; i += 2) {
                solution.complexNumberMultiply2(data.get(i), data.get(i + 1));
            }
            System.out.println("2 cost:" + (System.currentTimeMillis() - start));

        }

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String complexNumberMultiply2(String num1, String num2) {
            int a1 = Integer.parseInt(num1.substring(0, num1.indexOf('+')));
            int a2 = Integer.parseInt(num1.substring(num1.indexOf('+') + 1, num1.length() - 1));
            int b1 = Integer.parseInt(num2.substring(0, num2.indexOf('+')));
            int b2 = Integer.parseInt(num2.substring(num2.indexOf('+') + 1, num2.length() - 1));
            int aa = a1 * b1 - a2 * b2;
            int bb = a2 * b1 + a1 * b2;
            return aa + "+" + bb + "i";
        }

        public String complexNumberMultiply(String num1, String num2) {
            int[] a = parse(num1);
            int[] b = parse(num2);
            int aa = a[0] * b[0] - a[1] * b[1];
            int bb = a[0] * b[1] + a[1] * b[0];
            return String.valueOf(aa) + '+' + bb + 'i';
        }

        private int[] parse(String num) {
            int[] a = parseSingle(num, 0);
            int[] b = parseSingle(num, a[1] + 1);
            return new int[]{a[0], b[0]};
        }

        private int[] parseSingle(String str, int idx) {
            // parse +123, -321
            int sign = 1, num = 0;
            char c = str.charAt(idx);
            if (c == '+') {
                idx++;
            } else if (c == '-') {
                idx++;
                sign = -1;
            }
            while (idx < str.length() && Character.isDigit(str.charAt(idx))) {
                num = num * 10 + (str.charAt(idx) - '0');
                idx++;
            }
            num *= sign;
            return new int[]{num, idx};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}