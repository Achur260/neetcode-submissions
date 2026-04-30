class Solution {
    public String reorganizeString(String s) {

        HashMap<Character, Integer> hm = new HashMap<>();

        PriorityQueue<Character> pq = new PriorityQueue<Character>((n1,n2) -> {
            return hm.get(n2) - hm.get(n1);
        });


        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0)+1);
            max = Math.max(max, hm.get(s.charAt(i)));
        }

        if (max > (s.length() + 1)/2) {
            return "";
        }

        for (char key : hm.keySet()) {
            pq.add(key);
        }



        StringBuilder res = new StringBuilder();

        while (res.length() < s.length()) {
            
            char c1 = pq.remove();
            
            if (res.length() > 0 && res.charAt(res.length()-1) == c1) {
                char c2 = pq.remove();
                hm.put(c2, hm.get(c2)-1);
                res.append(c2);
                pq.add(c2);
            } else {
                res.append(c1);
                hm.put(c1, hm.get(c1)-1);
            }
            pq.add(c1);
        }




        return res.toString();


    }
}