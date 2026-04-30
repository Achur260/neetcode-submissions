class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] currAns = new int[n];


        Arrays.fill(currAns, Integer.MAX_VALUE);
        currAns[n-1] = 0;

        for (int i = m -1; i >= 0; i --) {
            currAns[n-1] += grid[i][n-1];
            for (int j = n - 2; j >= 0; j--) {

                currAns[j] = grid[i][j] + Math.min(currAns[j], currAns[j+1]);
            }
        }

        return currAns[0];

        
    }
}