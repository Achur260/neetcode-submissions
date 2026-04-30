class Solution {
    public int getSum(int a, int b) {
        
        int carry = 0;
        int sum = 0;
        for (int i = 0; i < 32; i++) {
            int a1 = a & 1;
            int b1 = b & 1;

            


            int s = (a1 ^ b1) ^ carry;
            carry =  (a1 & b1) | (a1 & carry) | (b1 & carry);
            sum = sum | (s << i);
            a = a >> 1;
            b = b >> 1;
            System.out.println(carry +" " + sum);

            System.out.println();
        }



        return sum;
    }
}
