class Solution {
    public boolean canTraverseAllPairs(int[] nums) {
        int max = 0;

        for (int num : nums) {
            max = Math.max(max, num);
        }

        int[] sieve = new int[max+1];

        for (int i = 2; i < sieve.length; i++) {
            if (sieve[i] != 0) {
                continue;
            }

            sieve[i] = i;
            long longI = (long) i;

            for (long j = longI*longI; j < (long) sieve.length; j+=i) {
                sieve[(int)j] = i;
            }
        }

        int n = nums.length;


        UnionFind uf = new UnionFind(n + 1 + max);

        for (int i = 0; i < nums.length; i++) {
            int t = nums[i];
            while (t>1) {
                int s = sieve[t];
                // System.out.println(t);
                // System.out.println(s);
                // System.out.println(n+s);
                uf.connect(i, n + s);
                t/=s;

                
            }

            // System.out.println(Arrays.toString(uf.root));
        }

        for (int i = 0; i < nums.length; i++) {
            if (!uf.isConnected(0,i)) {
                return false;
            }
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


    public int find(int x) {
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
        } else if (rank[rootY] > rank[rootX]) {
            root[rootX] = rootY;
        } else {
            root[rootY] = rootX;
            rank[rootX]++;
        }
    }
}