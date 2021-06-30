/*
 * @lc app=leetcode.cn id=297 lang=java
 *
 * [297] 二叉树的序列化与反序列化
 *
 * https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/description/
 *
 * algorithms
 * Hard (55.00%)
 * Likes:    586
 * Dislikes: 0
 * Total Accepted:    88.1K
 * Total Submissions: 160K
 * Testcase Example:  '[1,2,3,null,null,4,5]'
 *
 * 
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * 
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 /
 * 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * 
 * 提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode
 * 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：root = [1,2,3,null,null,4,5]
 * 输出：[1,2,3,null,null,4,5]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：root = []
 * 输出：[]
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：root = [1]
 * 输出：[1]
 * 
 * 
 * 示例 4：
 * 
 * 
 * 输入：root = [1,2]
 * 输出：[1,2]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 树中结点数在范围 [0, 10^4] 内
 * -1000 
 * 
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

  
    static TreeNode NULL_NODE = new TreeNode(-1);
    static String NULL_STR = "null";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int nodes = 1; // 标记未遍历的节点数

        while (!queue.isEmpty() && nodes > 0) {
            TreeNode poll = queue.poll();

            if (poll == NULL_NODE) {
                sb.append(NULL_STR).append(',');
            } else {
                nodes--;
                if (poll.left == null) {
                    queue.add(NULL_NODE);
                } else {
                    queue.add(poll.left);
                    nodes++;
                }
                if (poll.right == null) {
                    queue.add(NULL_NODE);
                } else {
                    queue.add(poll.right);
                    nodes++;
                }
                sb.append(poll.val).append(',');
            }

        }

        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0)
            return null;
        String[] vals = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        if (vals.length == 1)
            return root;

        int i = 1;
        int n = vals.length;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode p = queue.poll();
            if (i >= n) break;
            String l = vals[i++];
            if (!l.equals(NULL_STR)) {
                p.left = new TreeNode(Integer.parseInt(l));
                queue.offer(p.left);
            }

            if (i >= n) break;
            String r = vals[i++];
            if (!r.equals(NULL_STR)) {
                p.right = new TreeNode(Integer.parseInt(r));
                queue.offer(p.right);
            }
        }

        return root;
    }

}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
// @lc code=end

