package top.abosen.leetcode;

//[299] 猜数字游戏
/* "1807","7810" */
public class BullsAndCows{
    public static void main(String[] args) {
        Solution solution = new BullsAndCows().new Solution();
        System.out.println(solution.getHint("12345600", "12300005"));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String getHint(String secret, String guess) {
        int bull = 0, cow = 0;
        int[] sint = new int[10];
        int[] gint = new int[10];

        for (int i = 0; i < guess.length(); i++) {
            if (i < secret.length() && guess.charAt(i) == secret.charAt(i)) {
                bull ++;
            }
            gint[guess.charAt(i) - '0']++;
        }

        for (int i = 0; i < secret.length(); i++) {
            sint[secret.charAt(i)-'0']++;
        }

        for (int i = 0; i < 10; i++) {
            cow += Math.min(sint[i], gint[i]);
        }
        // cow 中包含了 bull
        cow -= bull;
        return bull + "A" + cow + "B";
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}