class Solution {
    public int numDecodings(String s) {
        
        int prev = 1;
        int doublePrev = 0;
        
        for (int i = 0; i < s.length(); i++) {
            int curr = 0;
            int num = Integer.parseInt(s.substring(i, i+1));
            if (num >= 1 && num <= 9) {
                curr += prev;
            } if (i > 0) {
                int num2 = Integer.parseInt(s.substring(i-1,i+1));
                if (num2 >= 10 && num2 <= 26) {
                    curr += doublePrev;
                }
            }

            doublePrev = prev;
            prev = curr;
        }

        return prev;
        
    }
}
