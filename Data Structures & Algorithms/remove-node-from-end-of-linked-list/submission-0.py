# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
'''class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        sz = 0
        current = head
        while current:
            sz += 1
            current = current.next
        deleted_node = sz-n
        if deleted_node == 0:
            return head.next
        current = head
        while deleted_node > 1:
            deleted_node -= 1
            current = current.next
        delete = current.next
        if delete:
            current.next = delete.next
        else :
            current.next = None
        return head'''
class Solution:        
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        current = head
        deleted = head
        i = 0
        while deleted and i < n+1:
            i += 1
            deleted = deleted.next
        if n == i :
            return head.next
        while deleted:
            current = current.next
            deleted = deleted.next
        current.next = current.next.next
        return head
                

        



        