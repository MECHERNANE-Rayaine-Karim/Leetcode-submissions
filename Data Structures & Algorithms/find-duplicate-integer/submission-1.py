class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        slow = 0
        fast = 0
        while True:
            slow = nums[slow]
            fast = nums[nums[fast]]
            if slow == fast:
                break
        i = 0
        while i != slow :
            i = nums[i]
            slow = nums[slow]                                
        return i
         