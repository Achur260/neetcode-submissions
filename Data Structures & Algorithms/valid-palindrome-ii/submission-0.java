class Solution {
    public boolean validPalindrome(String s) {

        int l = 0;
        int r = s.length()-1;

        while (l < r) {
            char lc = s.charAt(l);
            char rc = s.charAt(r);

            if (lc == rc) {
                l++;
                r--;
            } else {
                return isPalindrome(s, l+1, r) || isPalindrome(s, l, r-1);
            }
        }


        return true;

        
    }


    public boolean isPalindrome(String s, int l, int r) {

        while (l < r) {
            char lc = s.charAt(l);
            char rc = s.charAt(r);

            if (lc != rc) {
                return false;
            }

            l++;
            r--;
        }

        return true;
    }
}