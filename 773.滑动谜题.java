/*
 * @lc app=leetcode.cn id=773 lang=java
 *
 * [773] 滑动谜题
 *
 * https://leetcode-cn.com/problems/sliding-puzzle/description/
 *
 * algorithms
 * Hard (64.32%)
 * Likes:    177
 * Dislikes: 0
 * Total Accepted:    14.1K
 * Total Submissions: 20.5K
 * Testcase Example:  '[[1,2,3],[4,0,5]]'
 *
 * 在一个 2 x 3 的板上（board）有 5 块砖瓦，用数字 1~5 来表示, 以及一块空缺用 0 来表示.
 * 
 * 一次移动定义为选择 0 与一个相邻的数字（上下左右）进行交换.
 * 
 * 最终当板 board 的结果是 [[1,2,3],[4,5,0]] 谜板被解开。
 * 
 * 给出一个谜板的初始状态，返回最少可以通过多少次移动解开谜板，如果不能解开谜板，则返回 -1 。
 * 
 * 示例：
 * 
 * 
 * 输入：board = [[1,2,3],[4,0,5]]
 * 输出：1
 * 解释：交换 0 和 5 ，1 步完成
 * 
 * 
 * 
 * 输入：board = [[1,2,3],[5,4,0]]
 * 输出：-1
 * 解释：没有办法完成谜板
 * 
 * 
 * 
 * 输入：board = [[4,1,2],[5,0,3]]
 * 输出：5
 * 解释：
 * 最少完成谜板的最少移动次数是 5 ，
 * 一种移动路径:
 * 尚未移动: [[4,1,2],[5,0,3]]
 * 移动 1 次: [[4,1,2],[0,5,3]]
 * 移动 2 次: [[0,1,2],[4,5,3]]
 * 移动 3 次: [[1,0,2],[4,5,3]]
 * 移动 4 次: [[1,2,0],[4,5,3]]
 * 移动 5 次: [[1,2,3],[4,5,0]]
 * 
 * 
 * 
 * 输入：board = [[3,2,4],[1,5,0]]
 * 输出：14
 * 
 * 
 * 提示：
 * 
 * 
 * board 是一个如上所述的 2 x 3 的数组.
 * board[i][j] 是一个 [0, 1, 2, 3, 4, 5] 的排列.
 * 
 * 
 */

// @lc code=start
class Solution {
    static int MASK = 0xffffffff;

    public int slidingPuzzle(int[][] board) {
        int curState = convert(board);
        int tarState = convert(new int[][]{{1, 2, 3}, {4, 5, 0}});
        if (curState == tarState) return 0;

        // 标记走过的状态
        Set<Integer> visited = new HashSet<>();
        visited.add(-1);    // -1表示非法状态

        // 双向 bfs
        Set<Integer> a = new HashSet<>();
        a.add(curState);
        Set<Integer> b = new HashSet<>();
        b.add(tarState);

        int step = 0;

        while (!a.isEmpty() && !b.isEmpty()) {
            step++;
            Set<Integer> next = new HashSet<>();

            // 选择较少的一方进行bfs
            if (a.size() > b.size()) {
                Set<Integer> t = a;
                a = b;
                b = t;
            }
            for (Integer cur : a) {
                // 往四个方向移动
                for (int p = 0; p < 4; p++) {
                    int nextState = move(cur, p);
                    if (b.contains(nextState)) {
                        return step;
                    }
                    if (!visited.contains(nextState)) {
                        next.add(nextState);
                        visited.add(nextState);
                    }
                }
            }
            a = next;
        }

        return -1;
    }

    // 每一位最大是5，3个bit 共6位 18个bit 把0的位置信息也编码进去 共21个bit 用整数表示
    static int convert(int[][] board) {
        int state = 0;
        int zeroIdx = -1;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 0) {
                    zeroIdx = i * 3 + j;
                }
                state = (state << 3) | board[i][j];
            }
        }
        // 把 空缺的位置 编码到 末尾
        state = (state << 3) | zeroIdx;
        return state;
    }

    static int[][] convert(int state) {
        int[][] board = new int[2][3];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = get(state, i * 3 + j);
            }
        }
        return board;
    }

    /**
     * 往四个方向移动0，无法移动返回-1; p = 0↑,1↓,2←,3→
     */
    static int move(int state, int p) {
        int zeroIdx = get(state, 6);
        if (p == 0) { // up
            if (zeroIdx >= 3) return exchange(state, zeroIdx, zeroIdx - 3);
        } else if (p == 1) {// down
            if (zeroIdx < 3) return exchange(state, zeroIdx, zeroIdx + 3);
        } else if (p == 2) { // left
            if (zeroIdx != 0 && zeroIdx != 3) return exchange(state, zeroIdx, zeroIdx - 1);
        } else if (p == 3) { // right
            if (zeroIdx != 2 && zeroIdx != 5) return exchange(state, zeroIdx, zeroIdx + 1);
        }
        return -1;
    }

    /**
     * 获取目标状态指定位置的值
     *
     * @param pos 位置对应 [[0,1,2] [3,4,5]]， 6表示空缺的位置
     */
    static int get(int state, int pos) {
        int mask = (MASK << ((6 - pos) * 3)) & (MASK >>> ((7 - pos) * -3));
        return (state & mask) >> ((6 - pos) * 3);
    }

    /**
     * 设置目标状态指定位置的值
     *
     * @param pos 位置对应 [[0,1,2] [3,4,5]]， 6表示空缺的位置
     */
    static int set(int state, int pos, int value) {
        int mask = (MASK << ((6 - pos) * 3)) & (MASK >>> ((7 - pos) * -3));
        return (state & ~mask) | (value << ((6 - pos) * 3));
    }

    /**
     * 交换 空缺位置 和 指定位置的值， 返回新的状态
     */
    static int exchange(int state, int zeroIdx, int targetIdx) {
        int target = get(state, targetIdx);
        state = set(state, zeroIdx, target);
        state = set(state, targetIdx, 0);
        state = set(state, 6, targetIdx);   // 更新空缺位置坐标
        return state;
    }
}
// @lc code=end
