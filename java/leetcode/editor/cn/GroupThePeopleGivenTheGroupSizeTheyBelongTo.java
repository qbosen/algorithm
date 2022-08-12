package leetcode.editor.cn;
		  
import java.util.*;
import leetcode.editor.cn.struct.*;
		  
//[1282] 用户分组
/* [3,3,3,3,3,1,3] */
public class GroupThePeopleGivenTheGroupSizeTheyBelongTo{
    public static void main(String[] args) {
        Solution solution = new GroupThePeopleGivenTheGroupSizeTheyBelongTo().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        var map = new HashMap<Integer, List<Integer>>();
        var res = new ArrayList<List<Integer>>();
        for (int i = 0; i < groupSizes.length; i++) {
            int groupSize = groupSizes[i];
            var list = map.computeIfAbsent(groupSize, ArrayList::new);
            list.add(i);
            if(list.size() == groupSize){
                res.add(list);
                map.put(groupSize, new ArrayList<>());
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}