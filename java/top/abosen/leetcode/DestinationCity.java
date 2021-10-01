package top.abosen.leetcode;
		  
import java.util.*;
import top.abosen.leetcode.struct.*;
		  
//[1436] 旅行终点站
/* [["London","New,York"],["New,York","Lima"],["Lima","Sao,Paulo"]] */
public class DestinationCity{
    public static void main(String[] args) {
        Solution solution = new DestinationCity().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String destCity(List<List<String>> paths) {
        Map<String, String> map = new HashMap<>();
        for (List<String> path : paths) {
            map.put(path.get(0), path.get(1));
        }
        String p = paths.get(0).get(0);
        while (map.containsKey(p)) {
            p = map.get(p);
        }
        return p;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}