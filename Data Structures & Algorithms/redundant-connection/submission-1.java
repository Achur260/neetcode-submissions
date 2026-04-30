class Solution {
    public int[] findRedundantConnection(int[][] edges) {

        int[] res = new int[]{};
        UnionFind uf = new UnionFind(edges.length);

        for (int[] edge : edges) {

        
            if (uf.isConnected(edge[0] - 1, edge[1] - 1)) {
                res = edge;
            }

            else {
                uf.connect(edge[0] - 1, edge[1] - 1);
            }
        }


        return res; 
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

    public int findRoot(int x) {
        if (root[x] != x) {
            root[x] = findRoot(root[x]);
        }

        return root[x];
    }


    public boolean isConnected(int x, int y) {
        return findRoot(x) == findRoot(y);
    }

    public void connect(int x, int y) {
        if (isConnected(x, y)) {
            return;
        }


        int rootX = root[x];
        int rootY = root[y];

        if (rank[rootX] < rank[rootY]) {
            root[rootX] = rootY;
        } else if (rank[rootX] > rank[rootY]) {
            root[rootY] = rootX;
        } else {
            root[rootY] = rootX;
            rank[rootX]++;
        }
    }


}
