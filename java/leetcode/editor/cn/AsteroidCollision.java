package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Arrays;

//[735] 行星碰撞
/* [5,10,-5] */
public class AsteroidCollision {
    public static void main(String[] args) {
        Solution solution = new AsteroidCollision().new Solution();
        System.out.println(Arrays.toString(solution.asteroidCollision(new int[]{5, 10, -5})));
        System.out.println(Arrays.toString(solution.asteroidCollision(new int[]{8, -8})));
        System.out.println(Arrays.toString(solution.asteroidCollision(new int[]{10, 2, -5})));
        System.out.println(Arrays.toString(solution.asteroidCollision(new int[]{5, 5, -8})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] asteroidCollision(int[] asteroids) {
            var stack = new ArrayDeque<Integer>();
            for (int asteroid : asteroids) {
                while (true) {
                    if (stack.isEmpty()) {
                        stack.push(asteroid);
                        break;
                    }
                    int prev = stack.peek();
                    if (prev < 0 || asteroid > 0) {
                        stack.push(asteroid);
                        break;
                    }
                    int compare = Integer.compare(Math.abs(prev), Math.abs(asteroid));
                    if (compare == 0) {
                        stack.poll();
                        break;
                    } else if (compare < 0) {
                        // 右边大,继续往左找
                        stack.poll();
                        continue;
                    } else {
                        break;
                    }
                }
            }
            int[] res = new int[stack.size()];
            for (int i = res.length - 1; i >= 0; i--) {
                res[i] = stack.poll();
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}