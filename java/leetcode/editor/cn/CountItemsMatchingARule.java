package leetcode.editor.cn;

import java.util.List;

//[1773] 统计匹配检索规则的物品数量
/* [["phone","blue","pixel"],["computer","silver","lenovo"],["phone","gold","iphone"]],"color","silver" */
public class CountItemsMatchingARule {
    public static void main(String[] args) {
        Solution solution = new CountItemsMatchingARule().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
            int rule = "type".equals(ruleKey) ? 0 : "color".equals(ruleKey) ? 1 : 2;
            int count = 0;
            for (List<String> item : items) {
                if(ruleValue.equals(item.get(rule))){
                    count++;
                }
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}