# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        nodes = deque()
        nodes.append(root)
        while nodes:
            node = nodes.pop()
            if node:
                nodes.append(node.right)
                nodes.append(node.left)
                left_side = node.left
                node.left = node.right
                node.right = left_side
        return root