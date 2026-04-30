class Solution {
    public int uniquePaths(int m, int n) {
        
        int[] currRow = new int[n];
        int[] nextRow = new int[n];
        nextRow[n-1] = 1;


        for (int i = m - 1; i >= 0; i--) {
            
            currRow[n-1] = nextRow[n-1];

            for (int j = n-2; j >= 0; j--) {
                currRow[j] = currRow[j+1] + nextRow[j];
            }

            nextRow = Arrays.copyOf(currRow, n);
        }

        return currRow[0];
    }
}
