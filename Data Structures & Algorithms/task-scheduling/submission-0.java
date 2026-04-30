class Solution {
    public int leastInterval(char[] tasks, int n) {

        int[] counts = new int[26];
        for (char task : tasks) {
            counts[task - 'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int cnt : counts) {
            if (cnt > 0) {
                pq.add(cnt);
            }
        }    

        Queue<int[]> q = new LinkedList<>();

        int time = 0;

        while (!pq.isEmpty() || ! q.isEmpty()) {
            time++;

            if (!pq.isEmpty()) {
                int currC = pq.remove();
                currC--;
                if (currC > 0) {
                    q.add(new int[] {currC, time + n});
                }
            }

            while (!q.isEmpty() && q.peek()[1]== time) {
                pq.add(q.remove()[0]);
            }
        }

        return time;
    }
}
