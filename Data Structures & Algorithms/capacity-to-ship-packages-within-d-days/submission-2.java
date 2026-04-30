class Solution {
    public int shipWithinDays(int[] weights, int days) {

        int s = 0;
        int m = 0;
        for (int weight : weights) {
            s += weight;
            m = Math.max(weight, m);
        }


        int l = m; int r=s;

        int min = s;

        while (l <= r) {
            int mid = (l+r)/2;

            int c = 0;
            int d = 1;

            for (int weight : weights) {
                c += weight;
                if (c > mid) {
                    d++;
                    c=weight;
                }


                if (c > mid) {
                    d = Integer.MAX_VALUE;
                    break;
                }
            }


            if (d <= days && c <= mid) {
                r = mid - 1;
                min = Math.min(mid, min);
            } else {
                l = mid + 1;
            }
        }


        return min;
        
    }
}