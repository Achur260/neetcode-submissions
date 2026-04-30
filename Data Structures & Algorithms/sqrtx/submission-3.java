class Solution {
    public int mySqrt(int x) {

        int start = 0;
        int end = x;

        while (start <= end) {
            int mid = (start - end )/2 + end;


            if ((long)mid*mid==x) {
                return mid;
            } else if ((long)mid*mid < x) {
                start = mid+1;
            } else {
                end = mid - 1;
            }
        }


        return end;
        
    }
}