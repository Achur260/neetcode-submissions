class Solution {
    public int lengthOfLIS(int[] nums) {

        ArrayList<Integer> list = new ArrayList<>(nums.length);

        for (int num : nums) {
            if (list.isEmpty() || num > list.get(list.size()-1)) {
                list.add(num);
            } else {
                int x = Collections.binarySearch(list, num);
                if (x < 0) {
                    x = -x - 1;
                }
                list.set(x, num);

            }
        }


        return list.size();
        
    }
}
