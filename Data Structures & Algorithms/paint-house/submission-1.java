class Solution {
    public int minCost(int[][] costs) {


        int blue = 0;
        int red = 0;
        int green = 0;


        for (int i = costs.length - 1; i > -1; i--) {

            int prevRed = red; int prevGreen = green; int prevBlue = blue;
            blue = Math.min(prevRed, prevGreen) + costs[i][0];
            red = Math.min(prevBlue, prevGreen) + costs[i][1];
            green = Math.min(prevBlue, prevRed) + costs[i][2];

            System.out.println(blue + " " + red + " " + green);
        }

        return Math.min(blue, Math.min(red, green));
        
    }
}