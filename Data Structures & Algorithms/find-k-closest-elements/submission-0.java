class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> {
            int abs1 = Math.abs(n1 - x);
            int abs2 = Math.abs(n2 - x);

            if (abs1 == abs2) {
                return n2 - n1;
            }


            return abs2 - abs1;
        });


        for (int num : arr) {
            pq.add(num);

            if (pq.size() > k) {
                pq.remove();
            }
        }

        List<Integer> ans = new ArrayList<>();

        while (!pq.isEmpty()) {
            ans.add(pq.remove());
        }

        Collections.sort(ans, (n1, n2) -> {
            return n1 - n2;
        });


        return ans;
    }
}