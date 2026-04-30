class Solution {
    public int lengthOfLongestSubstring(String s) {

        HashSet<Character> hs = new HashSet<Character>();

        int start = 0;
        int end = 0;
        int maxLen = 0;

        while (end < s.length()) {
            if (!hs.contains(s.charAt(end))) {
                hs.add(s.charAt(end));
                end++;
                maxLen = Math.max(maxLen, end - start);
            } else {
                hs.remove(s.charAt(start));
                start++;
            }
        }




        return maxLen;
        
    }
}
