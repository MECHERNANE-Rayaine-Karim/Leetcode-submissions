class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        if head.next:
            current = head
            node1 = head
            node2 = head
            while node1 and node1.next:
                node1 = node1.next.next
                node2 = current   
                current = current.next    
            node2.next = None
            node1 = None
            while current:
                node2 = current.next
                current.next = node1
                node1 = current
                current = node2
            current = node1
            node1 = head
            while node1 and current:
                node2 = current
                current = current.next
                node2.next = node1.next
                node1.next = node2
                node2 = node1.next
                node1 = node1.next.next
            if current:
                node2.next = current
            if node1:
                node2.next = node1
        
            


        




        