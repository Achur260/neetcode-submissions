class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (n1,n2) -> {
            return n1[0] - n2[0];
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>((n1,n2) -> {
            return n1-n2;
        });

        int count = 0;

        for (int[] interval : intervals) {
            while (!pq.isEmpty() && interval[0] >= pq.peek()) {
                pq.remove();
            }

            if (!pq.isEmpty()) {
                pq.add(Math.min(interval[1], pq.remove()));
                count++;
            } else {
                pq.add(interval[1]);
            }
        }

        return count;
        
    }
}
