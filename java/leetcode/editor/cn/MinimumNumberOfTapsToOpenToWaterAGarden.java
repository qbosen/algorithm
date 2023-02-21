package leetcode.editor.cn;
		  
import java.util.*;
import leetcode.editor.cn.struct.*;
		  
//[1326] 灌溉花园的最少水龙头数目
/* 5,[3,4,1,1,0,0] */
public class MinimumNumberOfTapsToOpenToWaterAGarden{
    public static void main(String[] args) {
        Solution solution = new MinimumNumberOfTapsToOpenToWaterAGarden().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minTaps(int n, int[] ranges) {
        int[] right = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int r = ranges[i];
            if(i>r) right[i-r] = i+r;
            else right[0] = Math.max(right[0], i + r);
        }

        int res = 0;
        int curR = 0, nextR = 0;
        for (int i = 0; i < n; i++) {
            nextR = Math.max(nextR, right[i]);
            if (i == curR) {
                if(i== nextR) return -1;
                curR = nextR;
                res++;
            }
        }
        return  res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}