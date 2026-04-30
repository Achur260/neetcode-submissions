class Solution {

    
    public int splitArray(int[] nums, int k) {

        int s = 0;
        int m = Integer.MIN_VALUE;


        for (int num : nums) {
            s += num;
            m = Math.max(m, num);
        }


        int l = m;
        int r = s;

        int ans = Integer.MAX_VALUE;

        while (l <= r) {


            int rem = 1;
            int mid = (r-l)/2 + l;
            int csum = 0;

            for (int num : nums) {
                if (csum + num > mid) {
                    csum = num;
                    rem++;
                } else {
                    csum += num;
                }
            }

            if (rem > k) {
                l = mid + 1;
            } else {
                ans = Math.min(ans, mid);
                r = mid - 1;

            }
            

        }

        return ans;
        
    }

    // public int dp(int[] nums, int k, int i) {
        
    // }
}