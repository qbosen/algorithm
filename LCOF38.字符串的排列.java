// @algorithm @lc id=100308 lang=java 
// @title zi-fu-chuan-de-pai-lie-lcof

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    List<String> res;
    boolean[] vis;

    public String[] permutation(String s) {
        int n = s.length();
        res = new ArrayList<>();
        vis = new boolean[n];
        char[] arr = s.toCharArray();
        // 相同字符从左到右visit
        Arrays.sort(arr);

        StringBuffer sb = new StringBuffer();
        backtrack(arr, 0, n, sb);
        return res.toArray(String[]::new);
    }

    public void backtrack(char[] arr, int i, int n, StringBuffer sb) {
        if (i == n) {
            res.add(sb.toString());
            return;
        }
        // 给i位置 选一个没用过的字符，如果是相同字符则选第一个
        for (int j = 0; j < n; j++) {
            // 1. 当前字符已经使用
            // 2. 当前字符与前一个字符相同，但前一个字符未被使用，跳过
            if (vis[j] || (j > 0 && !vis[j - 1] && arr[j] == arr[j - 1])) {
                continue;
            }
            vis[j] = true;
            sb.append(arr[j]);
            backtrack(arr, i + 1, n, sb);
            sb.deleteCharAt(sb.length() - 1);
            vis[j] = false;
        }
    }
}