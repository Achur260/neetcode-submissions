class Solution {
    public int openLock(String[] deadends, String target) {

        HashSet<String> hs = new HashSet<>();
        for (String s : deadends) {
            hs.add(s);
        }

        if (target.equals("0000")) {
            return 0;
        }

        if (hs.contains("0000")) {
            return -1;
        }

        int step = 0;

        HashSet<String> seen = new HashSet<>();
        seen.add("0000");

        Queue<String> q = new LinkedList<>();
        q.add("0000");
        int x = 1;

        while (x > 0) {
            String curr = q.remove();
            x--;
            if (curr.equals(target)) {
                return step;
            }

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < 4; i++) {
                int dig = Integer.parseInt(curr.substring(i, i+1));

                int nextDig = (dig + 1)%10;
                int prevDig = (dig + 9)%10;

                String nextStr = sb.toString() + nextDig + curr.substring(i+1);
                String prevStr = sb.toString() + prevDig + curr.substring(i+1);

                if (!seen.contains(nextStr) && !hs.contains(nextStr)) {
                    seen.add(nextStr);
                    q.add(nextStr);
                }

                if (!seen.contains(prevStr) && !hs.contains(prevStr)) {
                    seen.add(prevStr);
                    q.add(prevStr);
                }

                sb.append(curr.charAt(i));

            }


            if (x == 0) {
                x = q.size();
                step++;
            }
        }


        return -1;
        
    }
}