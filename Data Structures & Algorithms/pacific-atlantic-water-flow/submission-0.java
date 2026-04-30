class Solution {
    
    int[][] dirs = new int[][] {{0,1}, {1,0}, {0,-1}, {-1,0}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {



        boolean[][] atl = new boolean[heights.length][heights[0].length]; 
        boolean[][] pac = new boolean[heights.length][heights[0].length];       
        int m = heights.length;
        int n = heights[0].length;
        
        for (int i = 0; i < m; i++) {
            if (!pac[i][0]) {
                dfs(heights, i, 0, pac);
            } 

            if (!atl[i][n-1]) {
                dfs(heights, i, n-1, atl);

            }
        }
        

        for (int j = 0; j < n; j++) {
            if (!pac[0][j]) {
                dfs(heights, 0, j, pac);
            } 

            if (!atl[m-1][j]) {
                dfs(heights, m-1, j, atl);
            }

        }

        ArrayList<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (atl[i][j] && pac[i][j]) {
                    ans.add(Arrays.asList(i,j));
                }
            }
        }

        return ans;

                
        
    }

    private void dfs(int[][] heights, int i, int j, boolean[][] oc) {
        oc[i][j] = true;
        for (int[] dir : dirs) {
            int newX = dir[0] + i;
            int newY = dir[1] + j;

            if (isValid(newX, newY, heights.length, heights[0].length) && heights[newX][newY] >= heights[i][j] && !oc[newX][newY]) {
                dfs(heights, newX, newY, oc);
            }
        }


    } 

    private boolean isValid(int x, int y, int m, int n) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
