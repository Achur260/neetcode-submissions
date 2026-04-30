class Solution {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((n1,n2) -> {
            return euclideanDistance(n1) - euclideanDistance(n2);
        });

        for (int[] point : points) {
            pq.add(point);
        }

        int[][] res = new int[k][2];

        int i = 0;

        while (i < k && !pq.isEmpty()) {
            res[i++] = pq.remove();
        }

        return res;
        

    }

    private int euclideanDistance(int[] point) {
        return point[0]*point[0] + point[1]*point[1];
    }
}
