package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.cn.struct.*;

//[1305] 两棵二叉搜索树中的所有元素
/* [2,1,4],[1,0,3], */
public class AllElementsInTwoBinarySearchTrees {
    public static void main(String[] args) {
        Solution solution = new AllElementsInTwoBinarySearchTrees().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        private void dfs(TreeNode root1, List<Integer> ansList) {
            if (root1 == null) {
                return;
            }
            dfs(root1.left, ansList);
            ansList.add(root1.val);
            dfs(root1.right, ansList);
        }

        private List<Integer> merge(List<Integer> list1, List<Integer> list2) {
            List<Integer> ansList = new ArrayList<>();
            int size1 = list1.size();
            int size2 = list2.size();
            int index1, index2;
            for (index1 = 0, index2 = 0; index1 < size1 && index2 < size2; ) {
                int num1 = list1.get(index1);
                int num2 = list2.get(index2);
                if (num1 < num2) {
                    ansList.add(num1);
                    index1++;
                } else {
                    ansList.add(num2);
                    index2++;
                }
            }

            while (index1 < size1) {
                ansList.add(list1.get(index1++));
            }

            while (index2 < size2) {
                ansList.add(list2.get(index2++));
            }

            return ansList;
        }

        public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
            List<Integer> ansList1 = new ArrayList<>();
            List<Integer> ansList2 = new ArrayList<>();
            dfs(root1, ansList1);
            dfs(root2, ansList2);

            return merge(ansList1, ansList2);
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}