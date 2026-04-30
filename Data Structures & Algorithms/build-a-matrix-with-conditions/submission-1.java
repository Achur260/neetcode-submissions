class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        
        int[] rowDegree = new int[k+1];
        int[] colDegree = new int[k+1];



        Map<Integer, HashSet<Integer>> rights = new HashMap<>();
        Map<Integer, HashSet<Integer>> down = new HashMap<>();


        for (int[] condition : rowConditions) {
            down.putIfAbsent(condition[0], new HashSet<>());

            if (!down.get(condition[0]).contains(condition[1])){
            down.get(condition[0]).add(condition[1]);
            rowDegree[condition[1]]++;}
        }

        for (int[] condition : colConditions) {
            rights.putIfAbsent(condition[0], new HashSet<>());

            if (!rights.get(condition[0]).contains(condition[1])){
            rights.get(condition[0]).add(condition[1]);
            colDegree[condition[1]]++;}
        }

        int i = 0;

        Queue<Integer> queue = new LinkedList<>();
        int[] rowList = new int[k];

        for (int j = 1; j <= k; j++) {
            if (rowDegree[j] == 0) {
                queue.add(j);
                rowDegree[j] = -1;
            }
        }

        int x = queue.size();

        while (x > 0) {
            int curr = queue.remove();
            rowList[i++] = curr;
            x--;

            if (down.containsKey(curr)) {
                for (int neighbor : down.get(curr)) {
                    rowDegree[neighbor]--;

                    if (rowDegree[neighbor] == 0) {
                        queue.add(neighbor);
                        rowDegree[neighbor] = -1;
                    }
                }
            }


            if (x == 0) {
                x = queue.size();
            }
        }


        


        if(i < k) {
            return new int[][]{};
        }

        

        i = 0;

        queue = new LinkedList<>();
        int[] colList = new int[k];

        for (int j = 1; j <= k; j++) {
            if (colDegree[j] == 0) {
                queue.add(j);
                colDegree[j] = -1;
            }
        }

        x = queue.size();

        while (x > 0) {
            int curr = queue.remove();
            colList[i++] = curr;
            x--;

            if (rights.containsKey(curr)) {
                for (int neighbor : rights.get(curr)) {
                    colDegree[neighbor]--;

                    if (colDegree[neighbor] == 0) {
                        queue.add(neighbor);
                        colDegree[neighbor] = -1;
                    }
                }
            }


            if (x == 0) {
                x = queue.size();
            }
        }


        System.out.println(Arrays.toString(colList) + " \n" + i);

        if(i < k) {
            return new int[][]{};
        }


        int[][] indexes = new int[k+1][2];

        for (int j = 0; j < k; j++) {
            indexes[rowList[j]][0] = j;
            indexes[colList[j]][1] = j;
        }

        int[][] ans = new int[k][k];

        for (int j = 1; j <= k; j++) {
            int r = indexes[j][0];
            int c = indexes[j][1];

            ans[r][c] = j;
        }

        System.out.println(Arrays.toString(colList));



        return ans;


        



    }
}