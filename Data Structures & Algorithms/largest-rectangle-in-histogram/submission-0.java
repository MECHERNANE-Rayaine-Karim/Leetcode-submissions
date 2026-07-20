class Solution {
    /*public int largestRectangleArea(int[] heights) {
        int surface = heights[0];
        int maxSurface = heights[0];
        for( int i = 0 ; i < heights.length ; i++ ){
            surface = heights[i];
            int width = 1;
            int height = heights[i];
            for( int j = i-1 ; j >= 0 ; j--  ){
                if( height <= heights[j] ) width++;
                else break;
            }
            for( int j = i+1 ; j < heights.length ; j++  ){
                if( height <= heights[j] ) width++;
                else break;
            }
            surface = height * width;
            maxSurface = Integer.max(maxSurface,surface);
            
        }
        return maxSurface;
    }*/

    public int largestRectangleArea(int[] heights) {
        ArrayDeque<Integer> stack = new ArrayDeque<>(); 
        int surface = heights[0];
        int maxSurface = heights[0];
        int[] rightBounderies = new int[heights.length];
        int[] leftBounderies = new int[heights.length];
        for( int i = 0 ; i < heights.length ; i++ ){
            while( !stack.isEmpty() && heights[i] < heights[stack.peek()] ){
                int index = stack.pop();
                rightBounderies[index] = i-index-1;
            }
            stack.push(i);
        }
        while( !stack.isEmpty()  ){
            int index = stack.pop();
            rightBounderies[index] = heights.length-index-1;
        }
        
        
        stack = new ArrayDeque<>();
        for( int i = heights.length-1 ; i >= 0  ; i-- ){
            while( !stack.isEmpty() && heights[i] < heights[stack.peek()] ){
                int index = stack.pop();
                leftBounderies[index] = index-i-1;
            }
            stack.push(i);
        }
        
        while( !stack.isEmpty()  ){
            int index = stack.pop();
            leftBounderies[index] = index;
        }

        
        for( int i = 0 ; i < heights.length ; i++ ){
            
            surface = heights[i]*(leftBounderies[i]+rightBounderies[i]+1);
            maxSurface = Integer.max(maxSurface,surface);
            
        }
        return maxSurface;
    }
}

