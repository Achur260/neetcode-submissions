class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    

    int[] A = nums1.length < nums2.length ? nums1 : nums2;
    int[] B = nums1.length < nums2.length ? nums2 : nums1;
    int start = 0;
    int end = A.length-1;

    int total = nums1.length + nums2.length;

    int half = (total+1)/2;

    int add1=-1;
    int add2=-1;

    while (start <= end) {
        int mid = (start+end)/2;
        add1 = mid;
        add2 = half-mid-1;
        
        if (add1 < 0 || add1 + 1 >= A.length || add2 < 0 || add2 >= B.length) {
            break;
        } 
        int arr1 = A[add1+1];
        int arr2 = B[half - mid-1];
        if (arr1 < arr2) {
            start = mid + 1;
        } else {
            break;
        }
         
    }

    System.out.println(add1 + " " + add2);


    if (nums1.length == 0) {
        if (total % 2 == 1) {
            return nums2[total/2];
        }

        return ((double) nums2[total/2]  + nums2[total/2-1])/2;
    }

    if (nums2.length == 0) {
        if (total % 2 == 1) {
            return nums1[total/2];
        }

        return ((double) nums1[total/2]  + nums1[total/2-1])/2;
    }
    if (add1 == -1 || add2 == -1) {
        if (total % 2 == 1) {
            if (add1 == -1)
                return B[add2];
            return A[add1];
        } else {
            if (add1 == -1) {
                return ((double) B[add2] + B[add2+1])/2;
            }
            return ((double) A[add1] + A[add1+1])/2;
        }
    }

    if (total % 2 == 1) {
        return Math.min((double) A[add1], (double) B[add2]);
    } else {
        return ((double) A[add1] + B[add2])/2;
    }




                    
        
    }
}
