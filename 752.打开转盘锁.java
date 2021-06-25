/*
 * @lc app=leetcode.cn id=752 lang=java
 *
 * [752] 打开转盘锁
 *
 * https://leetcode-cn.com/problems/open-the-lock/description/
 *
 * algorithms
 * Medium (49.64%)
 * Likes:    304
 * Dislikes: 0
 * Total Accepted:    48.6K
 * Total Submissions: 95.4K
 * Testcase Example:  '["0201","0101","0102","1212","2002"]\n"0202"'
 *
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8',
 * '9' 。每个拨轮可以自由旋转：例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 * 
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 * 
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 * 
 * 字符串 target 代表可以解锁的数字，你需要给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 -1 。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * 输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * 输出：6
 * 解释：
 * 可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
 * 注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
 * 因为当拨动到 "0102" 时这个锁就会被锁定。
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: deadends = ["8888"], target = "0009"
 * 输出：1
 * 解释：
 * 把最后一位反向旋转一次即可 "0000" -> "0009"。
 * 
 * 
 * 示例 3:
 * 
 * 
 * 输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"],
 * target = "8888"
 * 输出：-1
 * 解释：
 * 无法旋转到目标数字且不被锁定。
 * 
 * 
 * 示例 4:
 * 
 * 
 * 输入: deadends = ["0000"], target = "8888"
 * 输出：-1
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * deadends[i].length == 4
 * target.length == 4
 * target 不在 deadends 之中
 * target 和 deadends[i] 仅由若干位数字组成
 * 
 * 
 */

// @lc code=start
class Solution {
    Set<Integer> illegal;
    static int MASK = 0xffffffff;

    public int openLock(String[] deadends, String target) {
        // 排除不需要拧的情况
        if (target.equals("0000")) {
            return 0;
        }
        // 4bit 表示 一位， 16个bit表示一个状态 即一个 int
        illegal = new HashSet<>();
        for (String deadend : deadends) {
            illegal.add(convert(deadend));
        }

        int init = convert("0000");
        // 需要拧 但是拧不动
        if (illegal.contains(init)) {
            return -1;
        }
        Set<Integer> a = new HashSet<>(), b = new HashSet<>();
        a.add(init);
        b.add(convert(target));

        int count = 1;
        while (!a.isEmpty() && !b.isEmpty()) {
            // 选择较少的一方进行bfs
            if (a.size() > b.size()) {
                Set<Integer> t = a;
                a = b;
                b = t;
            }
            Set<Integer> next = new HashSet<>();
            for (Integer cur : a) {
                // 四个位置 上下旋转
                for (int p = 0; p < 4; p++) {
                    for (boolean direction : new boolean[]{true, false}) {
                        int nextState = rotate(cur, p, direction);
                        if (b.contains(nextState)) {   // 找到了路径
                            return count;
                        } else if (!illegal.contains(nextState)) { // 合法的下一阶段
                            next.add(nextState);
                            illegal.add(nextState);    // 标记已经访问过了
                        }
                    }
                }
            }
            a = next;
            count ++;
        }

        return -1;
    }

    private static int convert(String s) {
        int state = 0;
        for (int i = 0; i < 4; i++) {
            int num = s.charAt(i) - '0';
            state = (state << 4) | num;
        }
        return state;
    }

    private static String convert(int n) {
        char[] chars = new char[4];
        for (int i = 0; i < 4; i++) {
            int num = n & (0xf);
            n >>= 4;
            chars[3 - i] = (char) (num + '0');
        }
        return new String(chars);
    }

    private static int rotate(int state, int p, boolean b) {
        // p 旋转第几个位置 3,2,1,0 [i*4,(i+1)*4]
        int mask = (MASK << (p * 4)) & (MASK >>> (-4 * (p + 1)));
        int num = ((state & mask) >> (p * 4)) + (b ? 1 : -1);
        num = num > 9 ? 0 : (num < 0 ? 9 : num);
        return (state & ~mask) | (num << (p * 4));
    }
}
// @lc code=end
