class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        PriorityQueue<Integer> all = new PriorityQueue<Integer>((n1,n2) -> {
            return capital[n1]-capital[n2];
        });

        PriorityQueue<Integer> top = new PriorityQueue<Integer>((n1, n2) -> {
            return profits[n2]-profits[n1];
        });

        for (int i = 0; i < profits.length; i++) {
            all.add(i);
        }

        int rem = k;
        int currWeight = w;

        while (k > 0) {
            while (!all.isEmpty() && capital[all.peek()] <= currWeight) {
                top.add(all.remove());  
            }

            if (top.isEmpty()) {
                break;
            }

            currWeight += profits[top.remove()];
            k--;
        }

        return currWeight;
        
        
    }
}