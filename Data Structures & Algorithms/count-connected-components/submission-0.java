class Solution {
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);

        for (int[] edge : edges) {
            uf.connect(edge[0], edge[1]);
        }

        HashSet<Integer> hs = new HashSet<Integer>();

        for (int i = 0; i < n; i++) {
            hs.add(uf.findRoot(i));
        }

        return hs.size();

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

    
}
