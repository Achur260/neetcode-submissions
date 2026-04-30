class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (n1,n2) -> {
            return n1[0] - n2[0];
        });

        PriorityQueue<int[]> pq = new PriorityQueue<>((n1,n2) -> {
            return (n1[1]-n1[0]) - (n2[1]-n2[0]);
        });

        PriorityQueue<Integer> pqQ = new PriorityQueue<>((n1,n2) -> {
            return queries[n1] - queries[n2];
        });

        for (int i = 0; i < queries.length; i++) {
            pqQ.add(i);
        }
        
        int currIndex = 0;
        int[] res = new int[queries.length];

        while (!pqQ.isEmpty()) {
            int i = pqQ.remove();
            while (!pq.isEmpty()) {
                if (pq.peek()[1] < queries[i]) {
                    pq.remove();
                } else {
                    break;
                }
            } 

            while (currIndex < intervals.length) {

                if (intervals[currIndex][0] > queries[i])
                    break;
                if (intervals[currIndex][0] <= queries[i] && intervals[currIndex][1] >= queries[i])
                    pq.add(intervals[currIndex]);
                currIndex +=1;
            }

            if (pq.isEmpty()) {
                res[i] = -1;
            } else {
                res[i] = pq.peek()[1] - pq.peek()[0] + 1;
            }
        }


        return res;




    }
}
