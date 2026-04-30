class Solution {
    public int maxCoins(int[] nums) {
        int[] newArr = new int[nums.length + 2];
        newArr[0] = 1;
        newArr[newArr.length - 1] = 1;

        for (int i = 1; i < newArr.length - 1; i++) {
            newArr[i] = nums[i - 1];
        }

        int[][] memo = new int[newArr.length][newArr.length];

        for (int size = 1; size <= nums.length; size++) {
            for (int start = 1; start <= nums.length + 1 - size; start++) {
                int end = start + size - 1;
                    for (int mid = start; mid <= end; mid++) {
                        int left = memo[start][mid - 1];
                        int right = memo[mid + 1][end];
                        int gain = newArr[mid] * newArr[start - 1] * newArr[end + 1];
                        memo[start][end] = Math.max(memo[start][end], left + right + gain);
                    }
                

            }
        }

        return memo[1][nums.length];
    }
}
