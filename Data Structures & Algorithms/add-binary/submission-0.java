class Solution {
    public String addBinary(String a, String b) {

        int carry = 0;
        String sum  = "";

        for(int i = 1; i <= Math.max(a.length(), b.length()); i++) {
            int a1 = i <= a.length() ? Integer.parseInt(a.substring(a.length()-i,a.length()-i+1)) : 0;
            int b1 = i <= b.length() ? Integer.parseInt(b.substring(b.length()-i,b.length()-i+1)) : 0;



            int currDigit = (a1 ^ b1) ^ carry;

            carry = (a1 & b1) | (b1 & carry) | (a1 & carry);
            sum = currDigit + sum;
        }

        if (carry == 1)
            sum = carry + sum;
        return sum;
        
    }
}