class Solution {
    public int calculate(String s) {


        s = s.replaceAll(" ", "");

        int prev = 0;
        int sum = 0;
        char op = '+';


        int i = 0;

        while (i < s.length()) {
            int j = i;
            while(j < s.length() && Character.isDigit(s.charAt(j))) {
                j++;
            }

            int curr = Integer.parseInt(s.substring(i, j));

            if (op == '+') {
                sum += prev;
                prev = curr;

            } else if (op == '-') {
                sum += prev;
                prev = -curr;

            } else if (op == '*') {
                prev *= curr;


            } else if (op == '/') {
                prev /= curr;

            }



            if (j < s.length())
                op =  s.charAt(j);
            i = j+1;


        }

        sum += prev;

        return sum;

        
    }
}