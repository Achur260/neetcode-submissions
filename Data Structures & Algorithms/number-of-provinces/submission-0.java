class Solution {
    public int findCircleNum(int[][] isConnected) {

        UnionFind uf = new UnionFind(isConnected.length);

        for (int i = 0; i < isConnected.length; i++) {
            for (int j = i+1; j < isConnected.length; j++) {
                if (isConnected[i][j] == 1) {
                    uf.connect(i, j);
                }
            }
        }


        HashSet<Integer> hs = new HashSet<>();


        for (int i = 0; i < isConnected.length; i++) {
            hs.add(uf.find(i));
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


    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }

    public int find(int x) {
        if (root[x] != x) {
            return root[x] = find(root[x]);
        }

        return root[x];
    }


    public void connect(int x, int y) {
        if (!isConnected(x, y)) {
            int rootX = find(x);
            int rootY = find(y);

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
}