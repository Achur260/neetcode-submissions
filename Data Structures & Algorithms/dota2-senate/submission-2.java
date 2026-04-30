class Solution {
    public String predictPartyVictory(String senate) {

        Queue<Integer> rQ = new LinkedList<>();
        Queue<Integer> dQ = new LinkedList<>();

        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R') {
                rQ.add(i);
            } else {
                dQ.add(i);
            }
        }


        while (!rQ.isEmpty() && !dQ.isEmpty()) {
            if (rQ.peek() < dQ.peek()) {
                dQ.remove();
                rQ.add(rQ.remove()+senate.length());
            } else {
                rQ.remove();
                dQ.add(dQ.remove()+senate.length());
            }
        }

        if (rQ.isEmpty()) {
            return "Dire";
        }

        return "Radiant";
        
    }
}