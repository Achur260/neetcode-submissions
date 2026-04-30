class Solution {
    public String multiply(String num1, String num2) {
        
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        String currSum = "";

        int i = num2.length() - 1;
        while (i > -1) {
            String prod = mult(num1, num2.substring(i,i+1));
            String spaces = "0".repeat(num2.length() - 1 - i);
            System.out.println(prod + spaces);
            currSum = add(currSum, prod + spaces);
            i--;
        }

        return currSum;
    }

    public String add(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;

        int carry = 0;
        String sum = "";

        while (i > -1 && j > -1) {
            int n1 = Integer.parseInt(num1.substring(i,i+1));
            int n2 = Integer.parseInt(num2.substring(j,j+1));

            int curr = n1+n2+carry;

            carry = curr/10;
            curr = curr % 10;
            sum = curr + sum;
            i--;
            j--;
        }

        while (i > -1) {
            int n1 = Integer.parseInt(num1.substring(i,i+1));

            int curr = n1+carry;

            carry = curr/10;
            curr = curr % 10;
            sum = curr + sum;
            i--;
        }

        while (j > -1) {
            int n2 = Integer.parseInt(num2.substring(j,j+1));

            int curr = n2+carry;

            carry = curr/10;
            curr = curr % 10;
            sum = curr + sum;
            j--;
        }



        if (carry != 0) {
            sum = carry + sum;
        }

        return sum;

        
    }

    public String mult(String num1, String num2) {
        int m = Integer.parseInt(num2);

        int carry = 0;
        String sum = "";

        for (int i = num1.length()-1; i > -1; i--) {
            int curr = Integer.parseInt(num1.substring(i, i+1)) * m  + carry;
            carry = curr/10;
            curr = curr % 10;
            sum = curr + sum;
        }

        if (carry != 0) {
            sum = carry + sum;
        }

        return sum;
    }
}
