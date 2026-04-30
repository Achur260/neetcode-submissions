class KthLargest {


    PriorityQueue<Integer> pq;
    int k;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<Integer>((n1,n2) -> {
            return n1-n2;
        });
        this.k = k;

        for (int n : nums) {
            this.add(n);
        }
    }
    
    public int add(int val) {
        pq.add(val);
        if (pq.size() > k) {
            pq.remove();
        }

        return pq.peek();
    }
}
