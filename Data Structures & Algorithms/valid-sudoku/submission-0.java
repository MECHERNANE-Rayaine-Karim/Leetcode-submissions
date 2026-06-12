class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        int row,column;
        for( int k = 0 ; k < 9 ; k++ ){
            row = (k/3) *3;
            column = (k%3) *3;
            if( isValidSubBoard(board,row,column ) || isValidRow(board[k]) || isValidColumn(board,k)) return false;
            
        }
        return true;
        
        
    }


    public boolean isValidSubBoard(char[][] board, int row , int column ) {
        Set<Character> set = new HashSet<>();
        for( int i = row ; i < row + 3 ; i++ ) {
            for( int j = column ; j < column +3 ; j++ ){
                if( board[i][j] == '.') continue;
                if( !set.add(board[i][j]) ) return true;
            }
        }
        return false;
    }


    
    public boolean isValidRow(char[] row ){
        Set<Character> set = new HashSet<>();
        for( int i = 0 ; i < 9 ; i++ ) {
            if( row[i] == '.') continue;
            if( !set.add(row[i]) ) return true;
        }
        return false;
    }

    public boolean isValidColumn(char[][] board , int column ){
        Set<Character> set = new HashSet<>();
        for( int i = 0 ; i < 9 ; i++ ) {
            if( board[i][column] == '.') continue;
            if( !set.add(board[i][column]) ) return true;
        }
        return false;
    }
      

}
