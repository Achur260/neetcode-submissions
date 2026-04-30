class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        UnionFind uf = new UnionFind();
        for (int i = 0; i < equations.size(); i++) {
            uf.union(equations.get(i).get(0), equations.get(i).get(1), values[i]);
        }

        double[] ans = new double[queries.size()];
        int i = 0;

        for (List<String> query : queries) {
            ans[i++] = uf.getRatio(query.get(0), query.get(1));
        }

        return ans;
    }
}

class UnionFind {
    Map<String, String> parent;
    Map<String, Double> weight;
 
    public UnionFind() {
        parent = new HashMap<>();
        weight = new HashMap<>();
    }

    public void add(String a) {

        if (parent.containsKey(a)) {
            return;
        }
        parent.put(a, a);
        weight.put(a, 1.0);

    }

    public String find(String a) {
        if (!parent.get(a).equals(a)) {
            String p = parent.get(a);
            parent.put(a, find(p));
            weight.put(a, weight.get(a) * weight.get(p));
        }

        return parent.get(a);

    }

    public void union(String a, String b, double ratio) {
        add(a);
        add(b);
        String rootA = find(a);
        String rootB = find(b);

        if (!rootA.equals(rootB)) {
            parent.put(rootA, rootB);
            weight.put(rootA, ratio * weight.get(b)/weight.get(a));
        }

    }

    public double getRatio(String a, String b) {
        if (!parent.containsKey(a) || 
        !parent.containsKey(b) || 
        !find(a).equals(find(b))) {
            return -1.0;
        }

        return weight.get(a)/weight.get(b);

    }
}