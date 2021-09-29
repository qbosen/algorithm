package top.abosen.leetcode;

import java.util.*;
import top.abosen.leetcode.struct.*;

//[517] 超级洗衣机
/* [1,0,5] */
public class SuperWashingMachines{
    public static void main(String[] args) {
        Solution solution = new SuperWashingMachines().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMinMoves(int[] machines) {
        int total = Arrays.stream(machines).sum();
        int n = machines.length;
        if (total % n != 0) {
            return -1;
        }
        int avg = total/ n;
        int ans = 0, sum = 0;
        for (int num : machines) {
            num -= avg;
            sum += num;
            ans = Math.max(ans, Math.max(Math.abs(sum), num));
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}