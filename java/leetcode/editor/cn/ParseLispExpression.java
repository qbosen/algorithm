package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//[736] Lisp 语法解析
/* "(let,x,2,(mult,x,(let,x,3,y,4,(add,x,y))))" */
public class ParseLispExpression {
    public static void main(String[] args) {
        Solution solution = new ParseLispExpression().new Solution();
        System.out.println(solution.evaluate("(let x 3 x 2 x)"));
        System.out.println(solution.evaluate("(let x 2 (mult x (let x 3 y 4 (add x y))))"));
        System.out.println(solution.evaluate("(let x 1 y 2 x (add x y) (add x y))"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        char[] exp;

        public int evaluate(String expression) {
            this.exp = expression.toCharArray();
            return dfs(0, exp.length - 1, new HashMap<>());
        }

        public int dfs(int l, int r, Map<String, Integer> map) {
            if (exp[l] == '(') {
                char op = exp[l + 1];
                switch (op) {
                    case 'l' -> {
                        l += 5; //(let x
                        r--; //)
                        for (int i = l; i <= r; ) {
                            int j = expRange(i, r);
                            String key = new String(exp, i, j - i);
                            if (j > r) {   // 所有剩余的是一个表达式
                                return dfs(i, j - 1, new HashMap<>(map));
                            }
                            // 上面是一个 变量 key,下面是一个 可计算值的结果
                            i = j + 1;
                            j = expRange(i, r);
                            int value = dfs(i, j - 1, new HashMap<>(map));
                            map.put(key, value);
                            i = j + 1;
                        }
                        return -1;
                    }
                    case 'a' -> {
                        l += 5;
                        r--;
                        int j = expRange(l, r);
                        int a = dfs(l , j - 1, new HashMap<>(map));
                        int b = dfs(j + 1, r, new HashMap<>(map));
                        return a + b;
                    }
                    case 'm' -> {
                        l += 6;
                        r--;
                        int j = expRange(l, r);
                        int a = dfs(l, j - 1, new HashMap<>(map));
                        int b = dfs(j + 1, r, new HashMap<>(map));
                        return a * b;
                    }
                    default -> {
                        return -1;
                    }
                }
            } else {
                String current = new String(exp, l, r - l + 1);
                if (map.containsKey(current)) {
                    return map.get(current);
                } else {
                    return Integer.parseInt(current);
                }
            }
        }

        /**
         * 表达式的有效范围
         * <pre>
         * (let x 2 (mult x (let x 3 y 4 (add x y))))
         *          a                               b
         * 传入 a 返回 b，代表 [a, b) 表达式为 (mult x (let x 3 y 4 (add x y)))
         *
         * (let x 2 (mult x (let x 3 y 4 (add x y))))
         *      ab
         * 传入 a 返回 b，代表 [a, b) 表达式为 x
         * </pre>
         *
         * @param l   有效范围左闭端点
         * @param end 最远点
         * @return 有效范围右开端点
         */
        int expRange(int l, int end) {
            int r = l, score = 0;
            while (r <= end) {
                if (exp[r] == '(') {
                    score++;
                } else if (exp[r] == ')') {
                    score--;
                } else if (exp[r] == ' ') {
                    if (score == 0) break;
                }
                r++;
            }
            return r;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}