class Solution {
    public int numKLenSubstrNoRepeats(String s, int k) {
        int[] seen = new int[26];
        int unique = 0;
        int count = 0;

        if (k > 26) {
            return 0;
        }

        for (int r = 0; r < s.length(); r++) {
            
            if(seen[s.charAt(r) - 'a'] == 0) {
                unique++;
            }

            seen[s.charAt(r) - 'a']++;


            if (r - k + 1 >= 0) {
                if (unique == k) {
                    count++;
                }

                seen[s.charAt(r-k+1) - 'a']--;
                if (seen[s.charAt(r-k+1) - 'a'] == 0) {
                    unique--;
                }
            }

        }

        return count;
    }
}
