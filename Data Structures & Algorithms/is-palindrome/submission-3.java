class Solution {
    public boolean isPalindrome(String s) {

        int start = 0;
        int end = s.length() - 1;

        s = s.toLowerCase();

        while(start < s.length() && !isValid(s.charAt(start)))
            start++;
        while(end > -1 && !isValid(s.charAt(end))) 
            end--;

    


        while (start < end) {
            char sh = s.charAt(start);
            char e = s.charAt(end);

            if(sh != e) {
                return false;
            }

            start++;
            end--;

            while(start < s.length() && !isValid(s.charAt(start)))
                start++;
            while(end > -1 && !isValid(s.charAt(end))) 
                end--;

        
            
            
        
        }

        return true;

        
    }


    private boolean isValid (char ch) {
        return Character.isLetter(ch) || Character.isDigit(ch);
    }
}
