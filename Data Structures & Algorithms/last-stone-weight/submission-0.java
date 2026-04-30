class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((n1,n2)-> {
            return n2 -n1;
        });

        for (int stone : stones) {
            pq.add(stone);
        }

        while (pq.size() > 1) {
            int s1 = pq.remove();
            int s2 = pq.remove();

            int diff = Math.abs(s1-s2);

            if (diff != 0) {
                pq.add(diff);
            }
        }


        return pq.isEmpty() ? 0 : pq.peek();
        
    }
}
