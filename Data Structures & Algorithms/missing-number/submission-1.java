class Solution {
    public int missingNumber(int[] nums) {

        int res = 0;

        for (int num : nums) {
            int n = 1 << num;
            System.out.println(n);
            res = res | n;
        }

        for (int i = 0; i < 32; i++) {

            System.out.println(res);
            if ((res & 1) == 0) {
                return i;
            }

            res = res >> 1;
        }



        return -1;
        
    }
}
