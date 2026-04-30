class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> hm = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            hm.put(s1.charAt(i), hm.getOrDefault(s1.charAt(i),0)+1);
        }

        int count = hm.keySet().size();

        HashMap<Character, Integer> hmS = new HashMap<>();

        int start = 0;
        int end = 0;
        
        while (end < s2.length()) {
            System.out.println(start +" " + end);
            if (!hm.containsKey(s2.charAt(end))) {
                hmS.clear();
                count = hm.keySet().size();
                start = end+1;
                end = start;
            } else {
                
                hmS.put(s2.charAt(end), hmS.getOrDefault(s2.charAt(end), 0)+1);
                if (hmS.get(s2.charAt(end)) == hm.get(s2.charAt(end))) {
                    count--;
                } 

                if (count == 0) {
                    return true;
                }  
                System.out.println();
                while (start < end && hmS.get(s2.charAt(end)) > hm.get(s2.charAt(end))) {
                    hmS.put(s2.charAt(start), hmS.get(s2.charAt(start))-1);
                    if (hmS.get(s2.charAt(start)) == hm.get(s2.charAt(start))-1) 
                        count++;
                    System.out.println(count);
                    System.out.println(start);
                    System.out.println();
                    start++;
                }

                end++;
            }
        }

        return false;
    }
}
