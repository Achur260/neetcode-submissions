class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        Deque<Integer> dq = new ArrayDeque<Integer>();
        int[] ans = new int[nums.length + 1 -k];


        int start = 0;
        int end = 0;
        int i = 0;

        while (end < nums.length) {
            if (end - start + 1 > k) {
                ans[i] = dq.getFirst();
                if (nums[start] == dq.getFirst()) {
                    dq.removeFirst();
                }
                start++;
                i++;

            } else {
                while (!dq.isEmpty() && nums[end] > dq.getLast()) {
                    dq.removeLast();
                }
                dq.addLast(nums[end]);
                end++;
            }
        }


        ans[i] = dq.getFirst();
        return ans;
        
    }
}
