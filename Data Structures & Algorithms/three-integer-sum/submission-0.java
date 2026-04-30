class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();

        int i = 0;

        while (i < nums.length - 2) {

            int curr = nums[i];

            int start = i+1;
            int end = nums.length - 1;

            while (start < end) {
                int currTotal = nums[start] + nums[end];
                if (currTotal == -curr) {
                    List<Integer> arr = new ArrayList<>();
                    arr.add(curr);
                    arr.add(nums[start]);
                    arr.add(nums[end]);
                    ans.add(arr);

                    int prev = nums[start];
                    while(start < end && nums[start] == prev) {
                        start++;
                    }

                    prev = nums[end];

                    while(start < end && nums[end] == prev) {
                        end--;
                    }

                } else if (currTotal > - curr) {
                    end--;
                } else {
                    start++;
                }

            }


            while(i < nums.length-2 && nums[i] == curr) {
                i++;
            }

        }




        return ans;
        
    }
}
