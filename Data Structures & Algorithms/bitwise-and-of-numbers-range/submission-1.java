class Solution {
    public int rangeBitwiseAnd(int left, int right) {

        int prefix = 0;

        for (int i = 31; i >= 0; i--) {
            
            int pref = 1 << i;

            int a = left & pref;
            int b = right & pref;

            System.out.println(a);
            System.out.println(b);
            System.out.println(prefix);

            if (a != b) {
                break;
            }

            prefix = prefix | a;
        }

        return prefix;
        
    }
}