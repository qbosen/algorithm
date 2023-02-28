package leetcode.editor.cn;
		  
import java.util.*;
import leetcode.editor.cn.struct.*;
		  
//[2363] 合并相似的物品
/* [[1,1],[4,5],[3,8]],[[3,1],[1,5]] */
public class MergeSimilarItems{
    public static void main(String[] args) {
        Solution solution = new MergeSimilarItems().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int[] v : items1) {
            map.put(v[0], map.getOrDefault(v[0], 0) + v[1]);
        }
        for (int[] v : items2) {
            map.put(v[0], map.getOrDefault(v[0], 0) + v[1]);
        }

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int k = entry.getKey(), v = entry.getValue();
            List<Integer> pair = new ArrayList<Integer>();
            pair.add(k);
            pair.add(v);
            res.add(pair);
        }
        Collections.sort(res, (a, b) -> a.get(0) - b.get(0));
        return res;
    }
}

//leetcode submit region end(Prohibit modification and deletion)

}