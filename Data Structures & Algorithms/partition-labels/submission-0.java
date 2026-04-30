class Solution {
    public List<Integer> partitionLabels(String s) {

        HashMap<Character, Integer> hm = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            hm.put(s.charAt(i), i);
        }


        List<Integer> ans = new ArrayList<>();

        int start = 0;
        int end = 0;
        int endIndex = 0;
        while (end < s.length()) {
            endIndex = Math.max(endIndex, hm.get(s.charAt(end)));
            if (end == endIndex) {
                ans.add(end-start+1);
                start = end + 1;
                end = start;
            } else {
                end++;
            }
        }





        return ans;
        
    }
}
