class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        

        HashMap<Integer, LinkedList<List<Integer>>> hm = new HashMap<>();


        for (int[] time : times) {
            hm.putIfAbsent(time[0], new LinkedList<>());
            ArrayList<Integer> arr = new ArrayList<Integer>();
            arr.add(time[1]);
            arr.add(time[2]);
            hm.get(time[0]).add(arr);
        }


        int[] dist = new int[n+1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[k] = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>((n1,n2) -> {
            return dist[n1]-dist[n2];
        });
        pq.add(k);

        while (!pq.isEmpty()) {
            int curr = pq.remove();

            if (!hm.containsKey(curr)) {
                continue;
            }

            for (List<Integer> l : hm.get(curr)) {
                int newCurr = l.get(0);
                int newDist = l.get(1) + dist[curr];

                if (dist[newCurr] > newDist) {
                    dist[newCurr] = newDist;
                    pq.remove(newCurr);
                    pq.add(newCurr);
                }
            }
        }


        int max = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            if (i != k) {
                max = Math.max(max, dist[i]);
            }
        }



        return max != Integer.MAX_VALUE ? max : -1;


    }
}
