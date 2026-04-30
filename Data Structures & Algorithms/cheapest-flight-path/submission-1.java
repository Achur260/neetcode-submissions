class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        int[][] dist = new int[n][k+2];

        for (int[] d : dist)
            Arrays.fill(d, Integer.MAX_VALUE);
        dist[src][0] = 0;

        HashMap<Integer, HashSet<Integer[]>> hm = new HashMap<>();

        for (int[] flight : flights) {
            hm.putIfAbsent(flight[0], new HashSet<>());
            hm.get(flight[0]).add(new Integer[]{flight[1], flight[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((n1,n2) -> {
            return n1[0] - n2[0];
        });

        pq.add(new int[] {0, src, -1});
        while (!pq.isEmpty()) {
            int[] curr = pq.remove();
            

            if (curr[1] == dst)
                return curr[0];
            
            if (curr[2] >= k || curr[1] == dst) {
                continue;
            }

            if (hm.containsKey(curr[1])) {
                for (Integer[] edge : hm.get(curr[1])) {
                    
                    int newK = curr[2] + 1;
                    int newDist = curr[0] +edge[1];
                    if (newDist < dist[edge[0]][newK+1]) {
                        dist[edge[0]][newK+1] = newDist;
                        pq.add(new int[] {newDist, edge[0], newK});
                    }
                }
            }
            
        }





        int min = Integer.MAX_VALUE;
        for (int i = 0; i < k+1; i++) {
            min = Math.min(min, dist[dst][i]);
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    
    
    
    
    }





}
