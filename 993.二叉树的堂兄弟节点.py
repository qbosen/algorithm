#
# @lc app=leetcode.cn id=993 lang=python3
#
# [993] 二叉树的堂兄弟节点
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        queue = [root]
        while queue:
            counter = 0
            for _ in range(len(queue)):
                node = queue.pop(0)
                if node.left and node.right and (
                        (node.left.val == x and node.right.val == y) or
                        (node.left.val == y and node.right.val == x)):
                    # 亲兄弟
                    return False
                if node.val == x or node.val == y:
                    counter += 1
                    if counter == 2:
                        return True
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
        return False

# @lc code=end
