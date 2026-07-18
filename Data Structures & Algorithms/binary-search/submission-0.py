class Solution:
    def search(self, nums: List[int], target: int) -> int:
        left = 0
        right = len(nums)-1
        while( left <= right ):
            medium = (right+left)//2
            if nums[medium] == target: 
                return medium
            if nums[medium] < target:
                left = medium+1
            else:
                right = medium-1
        return -1