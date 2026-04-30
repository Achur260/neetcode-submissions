class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UnionFind uf = new UnionFind(accounts.size());

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < accounts.size(); i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);

                if (map.containsKey(email)) {
                    uf.union(i, map.get(email));
                } else {
                    map.put(email, i);
                }
            }
        }


        HashMap<Integer, HashSet<String>> res = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            int root = uf.find(i);
            if (!res.containsKey(root)) {
                res.put(root, new HashSet<>());
            }
            res.get(root).addAll(accounts.get(i));

        }

        List<List<String>> ans = new ArrayList<>();
        
        for (int key : res.keySet()) {
            ans.add(new ArrayList<>(res.get(key)));
        }

        return ans;
    }
}

class UnionFind {

    int[] rank;
    int[] root;

    public UnionFind(int n) {
        rank = new int[n];
        root = new int[n];

        for (int i = 0; i < n; i++) {
            rank[i] = 1;
            root[i] = i;
        }
    }

    public int find(int x) {
        if (root[x] != x) {
            root[x] = find(root[x]);
        }

        return root[x];
    }


    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }

    public void union(int x, int y) {
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