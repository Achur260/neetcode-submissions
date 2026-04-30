class Solution {
    public int subarraySum(int[] nums, int k) {
        

        HashMap<Integer, Integer> counts = new HashMap<>(); 
        int curr = 0;
        int count = 0;

        for (int num : nums) {

            System.out.println(num);
            System.out.println(count);

            curr += num;
            if (curr == k) {
                count++;
            }

            int rem = curr - k;

            if (counts.containsKey(rem)) {
                count += counts.get(rem);

            }

            counts.put(curr, counts.getOrDefault(curr, 0)+1);
        }

        return count;
        
    }
}