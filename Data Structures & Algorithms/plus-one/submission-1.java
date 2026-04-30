class Solution {
    public int[] plusOne(int[] digits) {

        double curr = 0;
        for (int num : digits) {
            System.out.println(curr);
            curr *= 10;

            curr += num;
        }

        curr = curr+1;
        System.out.println(curr);

        LinkedList<Double> r = new LinkedList<>();

        while (curr > 0) {
            r.addFirst(curr % 10);
            curr /= 10;
            curr = Math.floor(curr);
        }

        int[] res = new int[r.size()];

        int i = 0;
        for (double n : r) {
            res[i++] = (int) n;
        }

        return res;
        
    }
}
