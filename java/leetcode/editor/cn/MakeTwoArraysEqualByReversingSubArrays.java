package leetcode.editor.cn;
		  
import java.util.*;
import leetcode.editor.cn.struct.*;
		  
//[1460] 通过翻转子数组使两个数组相等
/* [1,2,3,4],[2,4,1,3] */
public class MakeTwoArraysEqualByReversingSubArrays{
    public static void main(String[] args) {
        Solution solution = new MakeTwoArraysEqualByReversingSubArrays().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int n = arr.length, tot = 0;
        int[] cnt = new int[1010];
        for (int i = 0; i < n; i++) {
            if (++cnt[target[i]] == 1) tot++;
            if (--cnt[arr[i]] == 0) tot--;
        }
        return tot == 0;
    }
}

//leetcode submit region end(Prohibit modification and deletion)

}