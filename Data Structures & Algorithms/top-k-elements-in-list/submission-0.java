class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        


        HashMap<Integer, Integer> counts = new HashMap<>();
        List<Integer>[] freq = new List[nums.length+1];

        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0)+1);
        }


        for (int num : counts.keySet()) {
            freq[counts.get(num)].add(num);

        }

        ArrayList<Integer> ans = new ArrayList<>(k);

        for (int index = freq.length-1; ans.size() < k && index > -1; index--) {

            for (int num : freq[index]) {

                ans.add(num);
                if (ans.size() == k) {
                    break;
                }
            }
        }

        int[] res = new int[k];

        for (int i = 0; i < k; i++) {
            res[i] = ans.get(i);
        }
        return res;

    
        

        
    }
}
