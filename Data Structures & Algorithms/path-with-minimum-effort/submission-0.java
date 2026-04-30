class Solution {
    public int minimumEffortPath(int[][] heights) {

        int[][] directions = new int[][] {{0,1}, {1,0}, {-1,0}, {0,-1}};


        int[][] dist = new int[heights.length][heights[0].length];


        PriorityQueue<Pair<Integer,Integer[]>> pq = new PriorityQueue<>((n1,n2) -> {
            return n1.getValue()[1] - n2.getValue()[1];
        });

        pq.add(new Pair<>(0,new Integer[]{0,0}));

        for (int[] d : dist) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        dist[0][0] = 0;

        while (!pq.isEmpty()) {
            Pair<Integer, Integer[]> curr = pq.remove();

            int currX = curr.getKey();
            Integer[] currArr = curr.getValue();
            int currY = currArr[0];
            int currW = currArr[1];

            if (currW > dist[currX][currY]) {
                continue;
            }

            for (int[] direction : directions) {
                int newX = currX + direction[0];
                int newY = currY + direction[1];

                if (newX >= heights.length || newX < 0 || 
                    newY >= heights[0].length || newY < 0 || 
                    dist[newX][newY] <= Math.max(currW, Math.abs(heights[currX][currY] - heights[newX][newY]))) {
                    continue;
                }

                dist[newX][newY] = Math.max(currW, Math.abs(heights[currX][currY] - heights[newX][newY]));
                pq.add(new Pair(newX, new Integer[]{newY, dist[newX][newY]}));
            }
        }



        return dist[heights.length-1][heights[0].length-1];
        
    }
}