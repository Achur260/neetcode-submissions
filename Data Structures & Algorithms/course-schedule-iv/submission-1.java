class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        
        int[] inDegree = new int[numCourses];

        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();

        HashMap<Integer, HashSet<Integer>> hm = new HashMap<>();

        for (int[] p : prerequisites) {
            int a = p[0];
            int b = p[1];
            graph.putIfAbsent(a, new HashSet<>());
            graph.putIfAbsent(b, new HashSet<>());
            

            graph.get(a).add(b);
            inDegree[b]++;

        }



        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {

            hm.putIfAbsent(i, new HashSet<Integer>());

            if (inDegree[i] == 0) {
                inDegree[i] = -1;
                queue.add(i);
            }
        }

        int x = queue.size();

        while (x > 0) {
            x--;
            int curr = queue.remove();
            


            if (graph.containsKey(curr)) {
                for (int neighbor : graph.get(curr)) {
                    inDegree[neighbor]--;
                    hm.get(neighbor).addAll(hm.get(curr));
                    hm.get(neighbor).add(curr);

                    if (inDegree[neighbor] == 0) {
                        inDegree[neighbor]--;
                        queue.add(neighbor);
                    }
                }
            }

            if (x == 0) {
                x = queue.size();
            }
            
        }

        List<Boolean> ans = new ArrayList<>();

        for (int[] query : queries) {
            int a = query[0];
            int b = query[1];

            if (hm.get(b).contains(a)) {
                ans.add(true);
            } else {
                ans.add(false);
            }
        }

        return ans;
    }
}