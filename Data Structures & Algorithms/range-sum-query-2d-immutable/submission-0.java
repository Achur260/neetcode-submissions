class NumMatrix {

    int[][] sums;
    public NumMatrix(int[][] matrix) {

        sums = new int[matrix.length][matrix[0].length];



        int cumSum = 0;
        for (int i = 0; i < matrix.length; i++) {
            cumSum += matrix[i][0];
            sums[i][0] = cumSum;
        }

        for (int j = 1; j < matrix[0].length; j++) {
            cumSum = 0;

            for (int i = 0; i < matrix.length; i++) {
                cumSum += matrix[i][j];
                sums[i][j] = cumSum + sums[i][j-1];
            }
        }


        for (int[] arr : sums) {
            System.out.println(Arrays.toString(arr));
        }

        System.out.println();      

        for (int[] arr : matrix) {
            System.out.println(Arrays.toString(arr));
        }  
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {

        if (row1 == 0 && col1 == 0) {
            return sums[row2][col2];
        }

        if (row1 == 0) {
            return sums[row2][col2] - sums[row2][col1-1];
        }

        if (col1 == 0) {
            return sums[row2][col2] - sums[row1-1][col2];
        }


        System.out.println(sums[row2][col2]);
        System.out.println(sums[row2][col1]);
        System.out.println(sums[row1][col2]);
        System.out.println(sums[row1-1][col1-1]);


        return sums[row2][col2] - sums[row2][col1-1] - sums[row1-1][col2] + sums[row1-1][col1-1];
        
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */