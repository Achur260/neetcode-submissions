class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> counts = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (counts.containsKey(target-nums[i])) {
                return new int[] {counts.get(target-nums[i]), i};
            }
            counts.put(nums[i], i);
        }

        return new int[] {};

        
    }
}
