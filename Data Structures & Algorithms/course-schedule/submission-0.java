class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        HashMap<Integer, List<Integer>> graph = new HashMap<>();

        int[] inDegree = new int[numCourses];

        for (int[] prereq : prerequisites) {
            graph.putIfAbsent(prereq[0], new ArrayList<Integer>());
            graph.get(prereq[0]).add(prereq[1]);
            inDegree[prereq[1]]++;
        }


        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i); 
                inDegree[i] = -1;
            }
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int curr = queue.remove();
            count++;

            if (!graph.containsKey(curr)) {
                continue;
            }

            for (int neighbor : graph.get(curr)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                    inDegree[neighbor] = -1;
                }
            }

        }


        return count == numCourses;
    }
}
