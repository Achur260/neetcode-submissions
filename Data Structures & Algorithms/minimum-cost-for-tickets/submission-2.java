class Solution {

    int[][] memo;
    public int mincostTickets(int[] days, int[] costs) {

        memo = new int[days.length][400];

        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }

        return dp(days, costs, 0, 0);
        
    }

    public int dp(int[] days, int[] costs, int i, int currDay) {
        if (i == days.length) {
            return 0;
        }

        if(memo[i][currDay] != -1) {
            return memo[i][currDay];
        }


        if (currDay >= days[i]) {
            return memo[i][currDay] = dp(days, costs, i+1, currDay);
        } 

        int min = Integer.MAX_VALUE;

    
        min = Math.min(min, costs[0] + dp(days, costs, i+1, days[i]));
        
        min = Math.min(min, costs[1] + dp(days, costs, i+1, days[i] + 6));
        

        min = Math.min(min, costs[2] + dp(days, costs, i+1, days[i] + 29));
    
        return memo[i][currDay] = min;
    }
}