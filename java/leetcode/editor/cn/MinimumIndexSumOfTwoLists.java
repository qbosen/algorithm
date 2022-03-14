package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.cn.struct.*;

//[599] 两个列表的最小索引总和
/* ["Shogun","Tapioca,Express","Burger,King","KFC"],["Piatti","The,Grill,at,Torrey,Pines","Hungry,Hunter,Steakhouse","Shogun"] */
public class MinimumIndexSumOfTwoLists {
    public static void main(String[] args) {
        Solution solution = new MinimumIndexSumOfTwoLists().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[] findRestaurant(String[] list1, String[] list2) {
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < list1.length; i++) {
                map.put(list1[i], i);
            }
            List<String> res = new ArrayList<>();
            int indexMinSum = Integer.MAX_VALUE;
            for (int i = 0; i < list2.length; i++) {
                Integer idx = map.get(list2[i]);
                if (idx == null) continue;
                int indexSum = idx + i;
                if (indexSum == indexMinSum) {
                    res.add(list2[i]);
                } else if (indexSum < indexMinSum) {
                    indexMinSum = indexSum;
                    res.clear();
                    res.add(list2[i]);
                }
            }
            return res.toArray(String[]::new);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}