class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        
        Arrays.sort(trips, (n1,n2) -> {
            return n1[1]-n2[1];
        });

        PriorityQueue<int[]> pq = new PriorityQueue<>((n1,n2) -> {
            return n1[2] - n2[2];
        });


        int score = 0;

        for (int[] trip : trips) {
            int time = trip[1];

            while (!pq.isEmpty() && time >= pq.peek()[2]) {
                int[] x = pq.remove();
                score -= x[0];
            }

            score += trip[0]; 
            if (score > capacity) {
                return false;
            }

            pq.add(trip);
        }


        return true;
    }
}