class Solution {
    public int maximalSquare(char[][] matrix) {

        int[] curr = new int[matrix[0].length];
        int[] prev = new int[matrix[0].length];

        int max = 0;

        for (int i = matrix.length-1; i > -1; i--) {
            for (int j = matrix[0].length-1; j>-1; j--) {
                if (matrix[i][j] == '0') {
                    curr[j] = 0;
                } else {
                    int right = j < matrix[0].length-1 ? curr[j+1] : 0;
                    int down = prev[j];
                    int diag = j < matrix[0].length-1 ? prev[j+1] : 0;

                    int min = 1+Math.min(right, Math.min(down, diag));

                    curr[j] = min;
                    max = Math.max(max, min);
                }
            }

            for (int x = 0; x < curr.length; x++) {
                prev[x] = curr[x];
            }

        }


        return max*max;
        
    }
}