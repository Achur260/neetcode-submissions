class Solution {
    public String minWindow(String s, String t) {

        HashMap<Character, Integer> hm = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            hm.put(t.charAt(i), hm.getOrDefault(t.charAt(i),0)+1);
        }

        HashMap<Character, Integer> currCounts = new HashMap<>();

        int count = hm.keySet().size();

        int start = 0;
        int end = 0;
        
        while (count > 0 && end < s.length()) {

            if (hm.containsKey(s.charAt(end))) {
                currCounts.put(s.charAt(end), currCounts.getOrDefault(s.charAt(end), 0) + 1);
                if (currCounts.get(s.charAt(end)).equals(hm.get(s.charAt(end)))) {
                    count--;
                }
            }
            end++;
        }

        if(count != 0) {
            System.out.println(count);
            return "";
        }

        int minLen = end-start;
        String curr = s.substring(start, end);
        end--;


        while (end < s.length()) {
            if (count == 0) {
                if (end+1-start < minLen) {
                    minLen = end+1-start;
                    curr = s.substring(start, end+1);
                }

                Character ch = s.charAt(start);
                start++;
                end = Math.max(end, start);
                if (currCounts.containsKey(ch)) {
                    currCounts.put(ch, currCounts.get(ch) - 1);
                    if (currCounts.get(ch) < hm.get(ch)) {
                        count++;
                    }
                }

            } else {

                end++;
                
                if (end >= s.length())
                    continue;
                char ch = s.charAt(end);
                if (currCounts.containsKey(ch)) {
                    currCounts.put(ch, currCounts.get(ch) + 1);
                    if (currCounts.get(ch).equals(hm.get(ch))) {
                        count--;
                    }
                }
                

            }
            
        }

        return curr;


        
        


        
    }
}
