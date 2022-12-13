package leetcode.editor.cn;

//[1832] 判断句子是否为全字母句
/* "thequickbrownfoxjumpsoverthelazydog" */
public class CheckIfTheSentenceIsPangram {
    public static void main(String[] args) {
        Solution solution = new CheckIfTheSentenceIsPangram().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkIfPangram(String sentence) {
            int TARGET = -1 >>> -26;
            int ans = 0;
            for (int i = 0; i < sentence.length(); i++) {
                int m = sentence.charAt(i) - 'a';
                ans |= (1 << m);
            }

            return ans == TARGET;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}