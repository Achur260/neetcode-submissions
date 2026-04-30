class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int first = m-1;
        int sec = n-1;

        int last = m+n-1;

        while (first > -1 && sec > -1) {
            if (nums1[first] > nums2[sec]) {
                nums1[last--] = nums1[first--];
            } else {
                nums1[last--] = nums2[sec--];
            }
        }

        while (first > -1) {
            nums1[last--] = nums1[first--];
        }

        while (sec > -1) {
            nums1[last--] = nums2[sec--];
        }
    }
}