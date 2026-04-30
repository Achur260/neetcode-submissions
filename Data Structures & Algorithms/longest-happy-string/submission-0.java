class Solution {
    public String longestDiverseString(int a, int b, int c) {

        

        Map<Character, Integer> count = new HashMap<>();
        count.put('a', a);
        count.put('b', b);
        count.put('c', c);



        StringBuilder sb = new StringBuilder();

        while (count.get('a') > 0 || count.get('b') > 0 || count.get('c') > 0) {

            char m = 'd';
            int max = 0;

            for (char ch : count.keySet()) {
                if (sb.length() < 2 || sb.charAt(sb.length()-1) != sb.charAt(sb.length()-2)) {
                    if (count.get(ch) > max) {
                        max = count.get(ch);
                        m = ch;
                    }
                } else if (sb.charAt(sb.length()-1) != ch) {
                    if (count.get(ch) > max) {
                        max = count.get(ch);
                        m = ch;
                    }
                }
            }

            if (m == 'd') {
                break;
            }
            sb.append(m);
            System.out.println(m);
            count.put(m, count.get(m)-1);

        }

        return sb.toString();

        
        
    }
}