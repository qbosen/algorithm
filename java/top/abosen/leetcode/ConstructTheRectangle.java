package top.abosen.leetcode;
		  
import java.util.*;
import top.abosen.leetcode.struct.*;
		  
//[492] 构造矩形
/* 4 */
public class ConstructTheRectangle{
    public static void main(String[] args) {
        Solution solution = new ConstructTheRectangle().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] constructRectangle(int area) {
        for (int i = (int)(Math.sqrt(area)); ;i--) {
            if (area % i == 0) return new int[]{area / i, i};
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}