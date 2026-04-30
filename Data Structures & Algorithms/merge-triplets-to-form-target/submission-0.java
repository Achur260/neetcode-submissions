class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {

        boolean a = false;
        boolean b = false;
        boolean c = false;

        for (int i = 0; i < triplets.length; i++) {
            if (triplets[i][0] > target[0] || triplets[i][1] > target[1] || triplets[i][2] > target[2]) {
                continue;
            }

            a = a | triplets[i][0] == target[0];
            b = b | triplets[i][1] == target[1];
            c = c | triplets[i][2] == target[2];

            if (a && b && c)
                return true;
        }



        return a && b && c;
        
    }
}
