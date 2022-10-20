package leetcode.editor.cn;

//[779] 第K个语法符号
/* 1,1 */
public class KThSymbolInGrammar {
    public static void main(String[] args) {
        Solution solution = new KThSymbolInGrammar().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int kthGrammar(int n, int k) {
            if (k == 1) {
                return 0;
            }
            if (k > (1 << (n - 2))) {
                return 1 ^ kthGrammar(n - 1, k - (1 << (n - 2)));
            }
            return kthGrammar(n - 1, k);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}