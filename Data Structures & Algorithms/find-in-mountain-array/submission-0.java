/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {

        int l = 0;
        int r = mountainArr.length()-1;
        int peak = -1;
        while (l <= r) {
            int mid = (l+r)/2;

            if (mountainArr.get(mid) > mountainArr.get(mid-1) && mountainArr.get(mid) > mountainArr.get(mid+1)) {
                peak = mid; break;
            } else if (mountainArr.get(mid) > mountainArr.get(mid-1)) {
                l = mid +1;

            } else {
                r = mid - 1;
            }


        }


         l = 0;
         r = peak;

        while (l <= r) {
            int mid = (l+r)/2;

            if (mountainArr.get(mid) == target) {
                return mid;
            } else if (mountainArr.get(mid) < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

         l = peak + 1;
         r = mountainArr.length()-1;

        while (l <= r) {
            int mid = (l+r)/2;

            if (mountainArr.get(mid) == target) {
                return mid;
            } else if (mountainArr.get(mid) < target) {
                r = mid - 1;
            } else {
                l = mid + 1; 
            }
        }

        return -1;


        
    }
}