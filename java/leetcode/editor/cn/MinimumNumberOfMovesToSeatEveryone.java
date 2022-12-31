package leetcode.editor.cn;
		  
import java.util.*;
import leetcode.editor.cn.struct.*;
		  
//[2037] 使每位学生都有座位的最少移动次数
/* [3,1,5],[2,7,4] */
public class MinimumNumberOfMovesToSeatEveryone{
    public static void main(String[] args) {
        Solution solution = new MinimumNumberOfMovesToSeatEveryone().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int count = 0;
        for (int i = 0; i < students.length; i++) {
            count += Math.abs(students[i] - seats[i]);
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}