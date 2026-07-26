class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        HashMap<Integer, List<Integer>> hm = new HashMap<>();

        for (int i = 0; i < pid.size(); i++) {
            int j = ppid.get(i);
            int l = pid.get(i);
            hm.putIfAbsent(j, new ArrayList<>());
            hm.get(j).add(l);
        }

        List<Integer> res = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();

        queue.add(kill);

        while(!queue.isEmpty()) {
            int rem = queue.remove();

            res.add(rem);

            if (!hm.containsKey(rem)) {
                continue;
            }

            for (int neighbor : hm.get(rem)) {
                queue.add(neighbor);
            }
        }


        return res;
    }
}
