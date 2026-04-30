class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        HashSet<Integer> ans = new HashSet<>();

        for (int num : nums) {
            hm.put(num, hm.getOrDefault(num, 0)+1);

            if (hm.get(num) > nums.length/3) {
                ans.add(num);
            }
        }

        return new ArrayList<>(ans);
        
    }
}