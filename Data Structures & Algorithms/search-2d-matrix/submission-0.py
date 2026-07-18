class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if( matrix[-1][-1] < target ):
            return False
        rows = 0
        while( rows < len(matrix) ):
            column = len(matrix[rows])
            for i in range(column):
                if( matrix[rows][i] == target ):
                    return True
                if( matrix[rows][i] > target ):
                    return False
            rows += 1
        return False


