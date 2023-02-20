package leetcode.editor.cn;

//[2347] 最好的扑克手牌
/* [13,2,3,1,9],["a","a","a","a","a"] */
public class BestPokerHand{
    public static void main(String[] args) {
        Solution solution = new BestPokerHand().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String bestHand(int[] ranks, char[] suits) {
        boolean flush = true;
        for (int i = 1; i < suits.length; i++) {
            if (suits[i] != suits[0]) {
                flush = false;
                break;
            }
        }
        if(flush) return "Flush";

        int[] count = new int[14];
        int maxCount = 0;
        for (int rank : ranks) {
            count[rank]++;
            maxCount = Math.max(maxCount, count[rank]);
        }
        if(maxCount >=3) return "Three of a Kind";
        if(maxCount >=2) return "Pair";
        return "High Card";
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}