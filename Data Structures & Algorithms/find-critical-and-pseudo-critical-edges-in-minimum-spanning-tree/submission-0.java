class Solution {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        
        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < edges.length; i++) {
            arr.add(i);
        }

        Collections.sort(arr, (n1, n2) -> {
            return edges[n1][2] - edges[n2][2];
        });

        int startWeight = 0;

        UnionFind uf = new UnionFind(n);

        for (int ind : arr) {
            int[] edge = edges[ind];

            int x = edge[0];
            int y = edge[1];

            if (uf.isConnected(x, y)) {
                continue;
            }

            uf.connect(x, y);
            startWeight += edge[2];

        }
        List<List<Integer>> ls = new ArrayList<>();
        ls.add(new ArrayList<>());
        ls.add(new ArrayList<>());


        for (int i = 0; i < edges.length; i++) {
            UnionFind ufExclude = new UnionFind(n);
            int excludeWeight = 0;
            int edgesCount = 0;

            for (int ind : arr) {
                if (ind == i) {
                    continue;
                }
                int[] edge = edges[ind];

                int x = edge[0];
                int y = edge[1];

                if (!ufExclude.isConnected(x, y)) {
                    ufExclude.connect(x, y);
                    excludeWeight += edge[2];
                    edgesCount++;
                }
            }

            if (edgesCount < n - 1 || excludeWeight > startWeight) {
                ls.get(0).add(i);
            } else {
                UnionFind ufInclude = new UnionFind(n);
                ufInclude.connect(edges[i][0], edges[i][1]);
                int includeWeight = edges[i][2];
                
                for (int ind : arr) {
                    if (ind == i) continue;
                    if (!ufInclude.isConnected(edges[ind][0], edges[ind][1])) {
                        ufInclude.connect(edges[ind][0], edges[ind][1]);
                        includeWeight += edges[ind][2];
                    }
                }
                
                if (includeWeight == startWeight) {
                    ls.get(1).add(i);
                }
            }
        }

        return ls;
    }
}

class UnionFind {
    int[] root;
    int[] rank;

    public UnionFind(int n) {
        root = new int[n];
        rank = new int[n];

        for (int i = 0; i < n ; i++) {
            root[i] = i;
            rank[i] =1;
        }
    }

    public int find (int x) {
        if (root[x] != x) {
            root[x] = find(root[x]);
        }
        return root[x];
    }

    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }


    public void connect(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) {
            return;
        }


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