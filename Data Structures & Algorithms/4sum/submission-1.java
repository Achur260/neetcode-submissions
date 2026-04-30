class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        Arrays.sort(nums);

        int i = 0;

        List<List<Integer>> ans = new ArrayList<>();

        while (i < nums.length-3) {

            if (nums[i] > target) {
                break;
            }
            int j = i + 1;

            while (j < nums.length-2) {

                if (nums[j] > target - nums[i]) {
                    break;
                }

                int rem = target - nums[i] - nums[j];

                int k = j + 1;
                int l = nums.length - 1;

                while (k < l) {
                    int cSum = nums[k] + nums[l];
                    if (cSum == rem) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        int n = nums[l];
                        while (l > k && nums[l] == n) {
                            l--;
                        }

                        n = nums[k];

                        while (l > k && nums[k] == n) {
                            k++;
                        }
                    } else if (cSum < rem) {
                        k++;
                    } else {
                        l--;
                    }
                }


                int n = nums[j];

                while (j < nums.length - 2 && nums[j] == n) {
                    j++;
                }


            }

            int n = nums[i];

            while (i < nums.length - 3 && nums[i] == n) {
                    i++;
                }
        }
        


        return ans;
    }
}