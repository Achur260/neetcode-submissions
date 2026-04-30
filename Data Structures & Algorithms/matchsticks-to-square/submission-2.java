class Solution {
    public boolean makesquare(int[] matchsticks) {

        return helper(matchsticks, 0,0,0,0,0);
        
    }

    public boolean helper(int[] matchsticks, int num1, int num2, int num3, int num4, int i) {

        if (i == matchsticks.length) {
            return num1 == num2 && num2 == num3 && num3 == num4 && num1 > 0;
        }



        return helper(matchsticks, num1+matchsticks[i], num2, num3, num4, i + 1) ||
                helper(matchsticks, num1, num2+matchsticks[i], num3, num4, i + 1) ||
                helper(matchsticks, num1, num2, num3+matchsticks[i], num4, i + 1) ||
                helper(matchsticks, num1, num2, num3, num4+matchsticks[i], i + 1);
    }
}