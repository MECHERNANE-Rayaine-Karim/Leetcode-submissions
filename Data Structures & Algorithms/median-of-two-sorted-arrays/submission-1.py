class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        if len(nums1) == 0:
            if len(nums2)%2 == 0:
                return (nums2[len(nums2)//2]+nums2[(len(nums2)//2)-1])/2
            return nums2[len(nums2)//2]
        if len(nums2) == 0:
            if len(nums1)%2 == 0:
                return (nums1[len(nums1)//2]+nums1[(len(nums1)//2)-1])/2
            return nums1[len(nums1)//2]
        a = 0
        b = 0
        c = 0
        d = 0
        if len(nums1) > len(nums2) :
            nums1, nums2 = nums2, nums1
        left = 0
        right = len(nums1)
        half = (len(nums1)+len(nums2)+1)//2
        while left <= right :
            i = left + (right-left)//2
            j = half - i
            if i-1 >= 0 and i < len(nums1):
                a = nums1[i-1]
                b = nums1[i]
            elif i-1 >= 0 :
                a = nums1[i-1]
                b = float("inf")
            else:
                a = float("-inf")
                b = nums1[i]
            if j-1 >= 0 and j < len(nums2):
                c = nums2[j-1]
                d = nums2[j]
            elif j-1 >= 0 :
                c = nums2[j-1]
                d = float("inf")
            else:
                c = float("-inf")
                d = nums2[j]
            if self.partion_is_valid(a,b,c,d):
                break
            if a > d :
                right = i-1
            elif c > b :
                left = i+1
                 
        if (len(nums1)+len(nums2)) % 2 == 0:
            return (max(a,c)+min(d,b))/2
        return max(a,c)
    def partion_is_valid(self, a : int , b : int , c : int , d : int) -> bool:

        return a <= d and c <= b 
        











        

        

