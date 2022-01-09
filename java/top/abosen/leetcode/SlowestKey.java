package top.abosen.leetcode;
		  
import java.util.*;
import top.abosen.leetcode.struct.*;
		  
//[1629] 按键持续时间最长的键
/* [9,29,49,50],"cbcd" */
public class SlowestKey{
    public static void main(String[] args) {
        Solution solution = new SlowestKey().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int n = releaseTimes.length;
        char ans = keysPressed.charAt(0);
        int maxTime = releaseTimes[0];
        for (int i = 1; i < n; i++) {
            char key = keysPressed.charAt(i);
            int time = releaseTimes[i] - releaseTimes[i - 1];
            if (time > maxTime || (time == maxTime && key > ans)) {
                ans = key;
                maxTime = time;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}