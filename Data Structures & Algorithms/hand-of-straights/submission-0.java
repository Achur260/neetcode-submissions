class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {

        if (hand.length % groupSize != 0) {
            return false;
        }

        int poss = hand.length/groupSize;

        TreeMap<Integer, Integer> counts = new TreeMap<>();

        for (int h : hand) {
            counts.put(h, counts.getOrDefault(h, 0)+1);
        }


        for (int num : counts.keySet()) {
            if (counts.get(num) == 0)
                continue;
            if (counts.get(num) > poss)
                return false;
            
            int countNum = counts.get(num);
            for (int i = 0; i < groupSize; i++) {
                if (!counts.containsKey(num+i) || counts.get(num+i) < countNum) {
                    return false;
                } 
                counts.put(num+i, counts.get(num+i)-countNum);
            }
        }


        return true;



        
    }
}
