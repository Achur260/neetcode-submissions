class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int end = 0;
        int maxLen = 0;

        HashSet<Character> hs = new HashSet<>();

        while (end < s.length()) {
            if (!hs.contains(s.charAt(end))) {
                hs.add(s.charAt(end));
                maxLen = Math.max(maxLen, end - start + 1);
                end++;
            } else {
                hs.remove(s.charAt(start));
                start++;
                maxLen = Math.max(maxLen, end - start + 1);
            }
        }


        return maxLen;
    }
}
