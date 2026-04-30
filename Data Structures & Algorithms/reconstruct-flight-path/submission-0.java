class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Collections.sort(tickets, (n1,n2) -> {
            return n1.get(1).compareTo(n2.get(1));
        });

        HashMap<String, List<String>> hm = new HashMap<>();

        for (List<String> ticket : tickets) {
            hm.putIfAbsent(ticket.get(0), new ArrayList<>());
            hm.get(ticket.get(0)).add(ticket.get(1));
        }

        List<String> res = new ArrayList<>();
        res.add("JFK");

        if (dfs(hm, tickets.size(), res))
            return res;
        return new ArrayList<>();
    }

    public boolean dfs(Map<String, List<String>> hm, int remLen, List<String> res) {
        if (remLen == 0) {
            return true;
        }

        String src = res.get(res.size()-1);


        if (!hm.containsKey(src))   
            return false;


        List<String> temp = new ArrayList<>(hm.get(src));
        for (int i = 0; i < temp.size(); i++) {
            String dest = temp.get(i);
            hm.get(src).remove(dest);
            res.add(dest);

            if (dfs(hm, remLen-1, res))
                return true;
            hm.get(src).add(i, dest);
            res.remove(res.size()-1);
        }

        return false;

    }
}
