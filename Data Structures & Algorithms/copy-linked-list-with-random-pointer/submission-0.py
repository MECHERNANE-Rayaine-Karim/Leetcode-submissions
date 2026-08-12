"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        if not head:
            return None
        copy = Node(head.val,None,None)
        node_map = {}
        node_map[head] = copy
        copy_node = copy
        node = head.next
        while node:  
            copy_node.next = Node(node.val,None,None)
            copy_node = copy_node.next
            node_map[node] = copy_node
            node = node.next
        copy_node = copy
        while head:
            if head.random: 
                copy_node.random = node_map[head.random]
            else:
                copy_node.random = None
            head = head.next
            copy_node = copy_node.next
        return copy
            
        

        