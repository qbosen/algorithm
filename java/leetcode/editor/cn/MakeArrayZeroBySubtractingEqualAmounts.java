package leetcode.editor.cn;
		  
import java.util.*;
import leetcode.editor.cn.struct.*;
		  
//[2357] 使数组中所有元素都等于零
/* [1,5,0,3,5] */
public class MakeArrayZeroBySubtractingEqualAmounts{
    public static void main(String[] args) {
        Solution solution = new MakeArrayZeroBySubtractingEqualAmounts().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumOperations(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for (int num : nums) {
            if(num > 0){
                set.add(num);
            }
        }
        return set.size();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}