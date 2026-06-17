class Solution {
    public int trap(int[] height) {
        if ( height.length < 2 ) return 0;
        int[] leftWalls = new int[height.length];
        int[] rightWalls = new int[height.length];
        int previousLeftWall = height[0];
        leftWalls[0] = 0;
        leftWalls[height.length-1] = 0;
        for( int i = 1 ; i < height.length-1 ; i++ ) {
            leftWalls[i] = leftWall(height,i,previousLeftWall);
            previousLeftWall = leftWalls[i];
        }
        int previousRightWall = height[height.length-1];
        rightWalls[0] = 0;
        rightWalls[height.length-1] = 0;
        for( int i = height.length-2 ; i >= 1 ; i-- ) {
            rightWalls[i] = rightWall(height,i,previousRightWall);
            previousRightWall = rightWalls[i];
        }
        int trapedWater = 0;
        for( int i = 1 ; i < height.length-1 ; i++ ) {
            int waterOnTop = Math.min(leftWalls[i],rightWalls[i]) - height[i];
            if( waterOnTop > 0 ) {
                trapedWater += waterOnTop;
            }
        }
        return trapedWater;
    }

    
    public int leftWall( int[] height , int index , int previousLeftWall ){
        if( height[index-1] > previousLeftWall ) return height[index-1];
        else return previousLeftWall;
    }

    public int rightWall( int[] height , int index , int previousRightWall ){
        if( height[index+1] > previousRightWall ) return height[index+1];
        else return previousRightWall;
    }


}