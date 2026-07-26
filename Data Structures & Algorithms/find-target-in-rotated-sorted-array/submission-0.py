class Solution:
    def search( self ,nums: List[int],target: int) -> int:
        left = 0
        right = len(nums)-1
        while left < right :
            mid = left + ( right - left )//2
            if  nums[mid] == target:
                return mid
            elif nums[left] < nums[right] and nums[mid] < nums[right]:
                if target > nums[mid]:
                    left = mid+1
                else:
                    right = mid
            elif nums[mid] < nums[right]:
                if target > nums[right] or target < nums[mid]:
                    right = mid
                else:
                    left = mid+1        
            else:
                if target <= nums[right] or target > nums[mid]:
                    left = mid+1
                else:
                    right = mid
        if nums[left] == target:
            return left
        return -1 
    
    
    
    