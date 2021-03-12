package leetcode.editor.cn;

//331 验证二叉树的前序序列化
/* "9,3,4,#,#,1,#,#,2,#,6,#,#" */
public class VerifyPreorderSerializationOfABinaryTree {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValidSerialization(String preorder) {
            String[] arr = preorder.split(",");
            int n = arr.length;
            if (n == 0) return false;

            int count = 1;
            for (String s : arr) {
                if (count == 0) return false;
                if ("#".equals(s)) count--;
                else count++;
            }
            return count == 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}