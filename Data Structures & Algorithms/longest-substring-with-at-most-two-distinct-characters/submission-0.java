class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {

        int l = 0;
        int r = 0;
        HashMap<Character, Integer> count = new HashMap<>();
        int maxLen = 0;



        while (r < s.length()) {
            
            count.put(s.charAt(r), count.getOrDefault(s.charAt(r), 0)+1);

            while(l <= r && count.keySet().size() > 2) {

                count.put(s.charAt(l), count.get(s.charAt(l))-1);
                if (count.get(s.charAt(l)) == 0) {
                    count.remove(s.charAt(l));
                }
                l++;
            }

            

            maxLen = Math.max(maxLen, r+1-l);
            r++;
        }


        return maxLen;
        
    }
}