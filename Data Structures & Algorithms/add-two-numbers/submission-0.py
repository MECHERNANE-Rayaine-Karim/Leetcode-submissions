# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        result = l1
        sum = 0
        carry = 0
        while l1 and l2 :
            sum = l1.val+l2.val+carry
            carry = 0
            if sum > 9:
                carry = 1
                sum = sum - 10
            l1.val = sum
            if not l1.next: 
                if not l2.next and carry == 1:
                    l1.next = ListNode(carry,None)
                    l1 = l1.next
                else:
                    l1.next = l2.next
                    l1 = l1.next
                    break
            l1 = l1.next
            l2 = l2.next
        while l1:
            sum = l1.val+carry
            carry = 0
            if sum > 9:
                carry = 1
                sum = sum - 10
            l1.val = sum
            if not l1.next and carry == 1:
                l1.next = ListNode(carry,None)
                l1 = l1.next
            l1 = l1.next            
                       
        return result






        
        