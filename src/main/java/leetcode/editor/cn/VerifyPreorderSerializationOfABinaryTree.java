package leetcode.editor.cn;

//331 验证二叉树的前序序列化
/* "9,3,4,#,#,1,#,#,2,#,6,#,#" */
public class VerifyPreorderSerializationOfABinaryTree {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValidSerialization(String preorder) {
            int n = preorder.length();

            int count = 1;
            int i = 0;
            while (i < n) {
                if (count == 0) return false;
                if (preorder.charAt(i) == ',') {
                    i++;
                } else if (preorder.charAt(i) == '#') {
                    count--;
                    i++;
                } else {
                    while (i < n && preorder.charAt(i) != ',') {
                        i++;
                    }
                    count++;
                }
            }
            return count == 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}