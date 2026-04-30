class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int start = 0;
        int end = matrix.length-1;

        while (start <= end) {
            int mid = (start + end)/2;

            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        if (end == -1)
            return false;

        int col = end;

        
        start = 0; 
        end = matrix[col].length - 1;

        while (start <= end) {
            int mid = (start + end)/2;

            if (matrix[col][mid] == target) {
                return true;
            } else if (matrix[col][mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return false;


        
    }
}
