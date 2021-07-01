// @algorithm @lc id=1000063 lang=java 
// @title chuan-di-xin-xi

public class Solution {
    int count;
    int n;
    int k;

    public int numWays(int n, int[][] relation, int k) {
        this.n = n;
        this.k = k;
        this.count = 0;

        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] r : relation) {
            map.compute(r[0], (_k, v) -> v == null ? new HashSet<>() : v).add(r[1]);
        }

        dfs(0, 0, map);
        return count;
    }

    void dfs(int round, int current, Map<Integer, Set<Integer>> relation) {
        if (round == k && current == n - 1) {
            count++;
            return;
        }
        if (round >= k) {
            return;
        }

        if (!relation.containsKey(current)) {
            return;
        }

        for (int next : relation.get(current)) {
            dfs(round + 1, next, relation);
        }
    }
}