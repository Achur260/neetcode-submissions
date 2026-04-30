class Solution {
    public boolean validTree(int n, int[][] edges) {

        UnionFind uf = new UnionFind(n);
        if (edges.length != n - 1) {
            return false;
        }

        for (int[] edge : edges) {
            if (uf.isConnected(edge[0], edge[1])) {
                return false;
            }

            uf.connect(edge[0], edge[1]);
        }

        return true;

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

        if (rank[rootX] > rank[rootY]) {
            root[rootY] = rootX;
        } else if (rank[rootX] < rank[rootY]) {
            root[rootX] = rootY;
        } else {
            root[rootY] = rootX;
            rank[rootX]++;
        }
    }
}