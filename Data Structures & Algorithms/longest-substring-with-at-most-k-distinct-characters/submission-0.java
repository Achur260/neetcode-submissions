class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {

        int[] seen = new int[26];
        int l = 0;
        int maxLen = 0;
        int unique = 0;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);

            if (seen[c - 'a'] == 0) {
                unique++;
            }

            seen[c-'a']++;

            while (unique > k && l <= r) {
                seen[s.charAt(l) - 'a']--;
                if (seen[s.charAt(l) - 'a'] == 0) {
                    unique--;
                }
                l++;
            }



            maxLen = Math.max(maxLen, r+1-l);
        }


        return maxLen;
        
    }
}
