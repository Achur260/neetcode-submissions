class Solution {
    public int subsetXORSum(int[] nums) {
        
        ArrayList<Integer> res = new ArrayList<>();
        int sum = 0;

        for (int num : nums) {

            List<Integer> nres = new ArrayList<>();
            for (int x : res) {
                int xor = num ^ x;
                    nres.add(xor);
                    sum += xor;
                
            }

            sum += num;
            nres.add(num);

            res.addAll(nres);
        }

        return sum;
    }
}