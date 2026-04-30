class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int[][] dist = new int[maze.length][maze[0].length];

        if(start[0] == destination[0] && start[1] == destination[1]) {
            return 0;
        }

        if (maze[destination[0]][destination[1]] == 1) {
            return -1;
        }

        for (int[] d : dist) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }

        dist[start[0]][start[1]] = 0;

        int[][] directions = new int[][] {{0,1}, {1,0}, {0,-1}, {-1,0}};


        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (n1, n2) -> {
                return n1[2] - n2[2];
            }
        );

        pq.add(new int[]{start[0], start[1], 0});



        while (!pq.isEmpty()) {
            int[] curr = pq.remove();

            System.out.println(Arrays.toString(curr));

            if (curr[2] > dist[curr[0]][curr[1]]) {
                continue;
            }

            


            for (int[] dir : directions) {
                int newX = curr[0];
                int newY = curr[1];
                int count = 0;

                while (newX + dir[0] > -1 && newX + dir[0] < maze.length && newY + dir[1] > -1 && newY + dir[1] < maze[0].length && maze[newX+dir[0]][newY+dir[1]] != 1) {
                    newX += dir[0];
                    newY += dir[1];

                    count++;
                }

                if (curr[2] + count < dist[newX][newY]) {
                    dist[newX][newY] = curr[2] + count;
                    pq.add(new int[] {newX, newY, curr[2] + count});
                }
            }



        }

        return dist[destination[0]][destination[1]] != Integer.MAX_VALUE ? dist[destination[0]][destination[1]] : -1;


        
    }
}
