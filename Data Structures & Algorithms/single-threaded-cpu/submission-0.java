class Solution {
    public int[] getOrder(int[][] tasks) {

        PriorityQueue<Integer> before = new PriorityQueue<>((n1,n2) -> {
            return tasks[n1][0] - tasks[n2][0];
        });


        PriorityQueue<Integer> after = new PriorityQueue<>((n1,n2) -> {
            return tasks[n1][1] - tasks[n2][1];
        });

        int currStart = Integer.MAX_VALUE;

        for (int i = 0; i < tasks.length; i++) {
            before.add(i);
            currStart = Math.min(currStart, tasks[i][0]);
        }

        int[] ans = new int[tasks.length];
        int i = 0;

        while (i < ans.length) {
            
            while (!before.isEmpty() && tasks[before.peek()][0] <= currStart) {
                after.add(before.remove());
            }

            if (after.isEmpty()) {
                after.add(before.remove());
            }

            int currTask = after.remove();

            currStart += tasks[currTask][1];

            ans[i++] = currTask;

        }


        return ans;


    }
    
}

