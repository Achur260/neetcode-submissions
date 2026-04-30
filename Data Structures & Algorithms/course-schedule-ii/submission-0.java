class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int[] ans = new int[numCourses];

        HashMap<Integer, List<Integer>> graph = new HashMap<>();

        int[] inDegree = new int[numCourses];


        for (int[] prereq : prerequisites) {
            graph.putIfAbsent(prereq[1], new ArrayList<>());
            graph.get(prereq[1]).add(prereq[0]);
            inDegree[prereq[0]]++;
        }  

        int currIndex = 0;
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                inDegree[i] = -1;
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int curr = queue.remove();
            ans[currIndex] = curr;
            currIndex++;

            if (!graph.containsKey(curr)) {
                continue;
            }

            for (int neighbor : graph.get(curr)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                    inDegree[neighbor]=-1;
                }
            }
        }

        if (currIndex != numCourses) {
            return new int[]{};
        }      

        return ans;
    }
}
