class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((n1,n2) -> {
            return n2 - n1;
        });

        int[] ans = new int[nums.length + 1 - k];

        int start = 0; 
        int end = 0;

        int i = 0;
        while (end < nums.length) {
            if (end + 1 - start > k) {
                ans[i] = pq.peek();
                i++;
                pq.remove(nums[start]);
                start++;
            } else {
                pq.add(nums[end]);
                end++;
            }
        }

        ans[ans.length-1] = pq.peek();

        return ans;


    }
}
