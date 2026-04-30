class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {


        if (n == 1) {
            return Arrays.asList(0);
        }
        Map<Integer, HashSet<Integer>> graph = new HashMap<>();


        int[] inDegree = new int[n];

        for (int[] edge : edges) {
            graph.putIfAbsent(edge[0], new HashSet<>());
            graph.putIfAbsent(edge[1], new HashSet<>());
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
            inDegree[edge[0]]++;
            inDegree[edge[1]]++;
        }


        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 1) {
                inDegree[i] = 0;
                queue.add(i);
            }
        }

        int count = 0;

        int x = queue.size();

        if (queue.size() == n) {
            return new ArrayList<>(queue);
        }


        System.out.println(queue);

        while (x > 0) {
                    System.out.println(queue);

            int curr = queue.remove();
            x--;
            count++;


            for (int neighbor : graph.get(curr)) {
                inDegree[neighbor]--;

                if (inDegree[neighbor] == 1) {
                    queue.add(neighbor);
                    inDegree[neighbor] = 0;
                }
            }


            if (x == 0) {
                x = queue.size();
                System.out.println(queue);
                if (x == n - count) {
                    break;
                }
            }
        }



        return new ArrayList<Integer>(queue);



        
    }
}