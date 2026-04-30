class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {

        int start = 0;

        int end = 0;
        int currSum = 0;
        int ans = 0;

        for (; end < k; end++) {
            currSum += arr[end];
        }

        while (end <= arr.length) {

            System.out.println(start + " " + end + " " + currSum);
            System.out.println();
            if (currSum >= threshold *k) {
                ans++;
            }

            if (end == arr.length) {
                break;
            }
            currSum += arr[end] - arr[start];
            end++;
            start++;
            
        }

        return ans;


        
    }
}