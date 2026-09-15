# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Combination:
    def __init__(self, level=0, node=None):
        self.level = level
        self.node = node
        

class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        depth = 0
        max_depth = 0
        stack = deque()
        
        while stack or root:
            if root:
                depth += 1
                stack.append(Combination(depth,root))
                root = root.left
                
            else:
                combination = stack.pop() 
                root = combination.node
                if not root.right:
                    max_depth = max(depth,max_depth)
                depth = combination.level
                root = root.right
                
            
                
                
        return max_depth
