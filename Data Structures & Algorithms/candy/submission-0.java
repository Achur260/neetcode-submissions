class Solution {
    public int candy(int[] ratings) {

        int[] arr1 = new int[ratings.length];
        arr1[0] = 1;

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i-1]) {
                arr1[i] = arr1[i-1] + 1;
            } else {
                arr1[i] = 1;
            }
        }

        int[] arr2 = new int[ratings.length];
        arr2[arr2.length - 1] = 1;

        for (int i = arr2.length-2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1]) {
                arr2[i] = 1 + arr2[i+1];
            } else {
                arr2[i] = 1;
            }
        }

        int sum = 0;

        for (int i = 0; i < ratings.length; i++) {
            sum += Math.max(arr1[i], arr2[i]);
        }

        return sum;

        
    }
}