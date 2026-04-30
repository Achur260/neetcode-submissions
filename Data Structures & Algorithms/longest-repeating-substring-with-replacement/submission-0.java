class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> hm = new HashMap<>();

        int left = 0;
        int maxF = 0;
        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0)+1);
            maxF = Math.max(maxF, hm.get(s.charAt(i)));

            while (i - left + 1 - maxF > k) {
                hm.put(s.charAt(left), hm.get(s.charAt(left)) - 1);
                left++;
            }

            res = Math.max(res, i - left + 1);
        }

        return res;
    }
}
