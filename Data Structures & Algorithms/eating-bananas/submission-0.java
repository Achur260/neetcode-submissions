class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = -1;

        int ans = Integer.MAX_VALUE;
        for (int num : piles) {
            end = Math.max(end, num);
        }

        while (start <= end) {
            int mid = (start+end)/2;

            int hrs = 0;
            for (int pile : piles) {
                hrs += Math.ceil(((double) pile)/((double) mid));
            }

            if (hrs <= h) {
                ans = Math.min(ans, mid);
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }


        return ans;
    }
}
