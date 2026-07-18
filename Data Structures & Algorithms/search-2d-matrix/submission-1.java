class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if( matrix[matrix.length-1][matrix[matrix.length-1].length-1] < target ) return false;
        int rows = 0;
        while( rows < matrix.length ){
            int column = matrix[rows].length;
            for( int i = 0 ; i < column ; i++ ){
                if( matrix[rows][i] == target ) return true;
                if( matrix[rows][i] > target ) return false;
            }
            rows++;
        }
        return false;
    }
}
