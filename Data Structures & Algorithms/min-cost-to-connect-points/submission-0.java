class Solution {
    public int minCostConnectPoints(int[][] points) {

        ArrayList<int[]> edges = new ArrayList<>();

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                edges.add(new int[] {
                    i,
                    j,
                    Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1])
                });
            }
        }

        edges.sort((n1,n2) -> {
            return n1[2] - n2[2];
        });

        int total = 0;
        UnionFind uf = new UnionFind(points.length);

        for (int[] edge : edges) {
            int v1 = edge[0];
            int v2 = edge[1];

            if (!uf.isConnected(v1, v2)) {
                total += edge[2];
                uf.connect(v1, v2);
            }

        }

        return total;


        
    }
}

class UnionFind {

    int[] root;
    int[] rank;

    public UnionFind(int n) {
        root = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            root[i] = i;
            rank[i] = 1;
        }
    }

    public void connect(int x, int y) {


        if (isConnected(x, y)) {
            return;
        }

        int rootX = findRoot(x);
        int rootY = findRoot(y);



        if (rank[rootX] > rank[rootY]) {
            root[rootY] = rootX;
        } else if (rank[rootY] > rank[rootX]) {
            root[rootX] = rootY;
        } else {
            root[rootY] = rootX;
            rank[rootX]++;
        }

    }


    public int findRoot(int x) {
        if (root[x] != x) {
            root[x] = findRoot(root[x]);
        }
        return root[x];
    }

    public boolean isConnected(int x, int y) {
        return findRoot(x) == findRoot(y);
    }


}
