class Solution {

    int[][] counts;
    int[][][] memo;
    public int findMaxForm(String[] strs, int m, int n) {

        memo = new int[strs.length][m + 1][n + 1];

        for (int[][] mem : memo) {
            for (int[] me : mem) {
                Arrays.fill(me, -1);
            }
        }


        counts = new int[strs.length][2];


        for (int i = 0; i < strs.length; i++) {

            for (int j = 0; j < strs[i].length(); j++) {
                if (strs[i].charAt(j) == '0') {
                    counts[i][0]++;
                } else {
                    counts[i][1]++;
                }
            }
        }


        return dp(strs, 0, m, n);
        
    }

    public int dp(String[] strs, int i, int m, int n) {
        if (i == strs.length) {
            return 0;
        }

        if (memo[i][m][n] != -1) {
            return memo[i][m][n];
        }

        int newM = m - counts[i][0];
        int newN = n - counts[i][1];

        int max = dp(strs, i+1, m, n);

        if (newM >= 0 && newN >= 0) {
            max = Math.max(max, 1 + dp(strs, i+1, newM, newN));
        }


        return memo[i][m][n] = max;


    } 
}