package leetcode.editor.cn;
		  
import java.util.*;
import leetcode.editor.cn.struct.*;
		  
//[1189] “气球” 的最大数量
/* "nlaebolko" */
public class MaximumNumberOfBalloons{
    public static void main(String[] args) {
        Solution solution = new MaximumNumberOfBalloons().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxNumberOfBalloons(String text) {
        Map<Character, Integer> counter = counter(text);
        int res = Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> kv : counter("balloon").entrySet()) {
            res = Math.min(res, counter.getOrDefault(kv.getKey(), 0) / kv.getValue());
        }
        return res;

    }

    private Map<Character, Integer> counter(String text) {
        Map<Character, Integer> counter = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            counter.compute(ch, (k,v)->v==null?1:v+1);
        }
        return counter;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}