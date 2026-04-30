class Solution {
    public int maxTurbulenceSize(int[] arr) {

        int max = 1;
        int curr = 0;

        int greater = -1;

        for (int i = 0; i < arr.length-1; i++) {
            if (greater == -1) {
                if (arr[i+1] > arr[i]) {
                    curr = 2;
                    greater = 0;
                } else if (arr[i+1] < arr[i]) {
                    curr = 2;
                    greater = 1;
                } else {
                    curr = 0;
                }


                max = Math.max(max, curr);
                
            } else if (greater == 1) {
                if (arr[i+1] >  arr[i]) {
                    curr++;
                    greater = 0;
                } else {
                    curr = 0;
                    greater = -1; 
                    i--;
                }

                max = Math.max(curr, max);
            } else {
                if (arr[i+1] <  arr[i]) {
                    curr++;
                    greater = 1;
                } else {
                    curr = 0;
                    greater = -1; 
                    i--;
                }

                max = Math.max(curr, max);
            }
        }

        return max;
        
    }
}