class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        
        double[] dist = new double[n];

        Arrays.fill(dist, 0);
        dist[start_node] = 1.0;

        Map<Integer, List<Pair<Integer,Double>>> graph = new HashMap<>();

        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.putIfAbsent(edge[1], new ArrayList<>());
            graph.get(edge[0]).add(new Pair<>(edge[1], succProb[i]));
            graph.get(edge[1]).add(new Pair<>(edge[0], succProb[i]));
        }

        PriorityQueue<Pair<Integer, Double>> pq = new PriorityQueue<Pair<Integer, Double>>((n1,n2) -> {
            return Double.compare(n2.getValue(), n1.getValue());
        });



        pq.add(new Pair<Integer, Double>(start_node, 1.0));


        while (!pq.isEmpty()) {
            Pair<Integer, Double> curr = pq.remove();

            if (dist[curr.getKey()] > curr.getValue()) {
                continue;
            }

            if (graph.containsKey(curr.getKey())) {
                for (Pair<Integer, Double> edge : graph.get(curr.getKey())) {
                    double newProb = edge.getValue() * curr.getValue();
                    if (newProb > dist[edge.getKey()]) {
                        dist[edge.getKey()] = newProb;
                        pq.add(new Pair<>(edge.getKey(), newProb));
                    }
                }
            }
        }



        return dist[end_node];
    }
}