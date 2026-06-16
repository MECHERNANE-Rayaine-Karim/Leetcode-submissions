class Solution {
    public int maxArea(int[] height) {
        int area = 0;
        int maxArea = 0;
        int start = 0;
        int end = height.length-1;

        while( start < end ) {
            if( height[start] >= height[end] ) {
                area = (end-start)*height[end];
                maxArea = Integer.max(area,maxArea);  
                end--;
            }
            else {
                area = (end-start)*height[start];
                maxArea = Integer.max(area,maxArea);  
                start++;
            }
        } 
        
        return maxArea;
    }
}