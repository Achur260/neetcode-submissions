class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int currSat = 0;

        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                currSat += customers[i];
            }
        }


        int l = 0;
        int maxMin = 0;
        int currSav = 0;

        for (int r = 0; r < grumpy.length; r++) {
            currSav += customers[r]*grumpy[r];
            if (r == l+minutes-1) {
                maxMin =  Math.max(maxMin, currSav);
                currSav -= customers[l]*grumpy[l];
                l++;
            } 
        }


        return maxMin + currSat;
    }
}