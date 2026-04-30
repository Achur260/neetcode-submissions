class Solution {
    public int totalNQueens(int n) {

        return helper(new HashSet<Integer>(), 0, n, n);
        
    }

    public int helper (HashSet<Integer> queens, int i, int rem, int n) {
        
        if (rem == 0) {
            return 1;
        }

        if (i >= n*n) {
            return 0;
        }
       
       
        int rowstart = (i/n)*n;
        boolean canPlace = true;
        
        for (int j = rowstart; j < i; j++) {
            if (queens.contains(j)) {
                canPlace = false;
                break;
            }
        }

        int x = i - n;


        while (x >= 0 && canPlace) {
            if (queens.contains(x)) {
                canPlace = false;
                break;
            }
            x-=n;
        }

        x = i - (n+1);

        while (x >= 0 && x % n >= 0 && x % n < i % n && canPlace) {
            if (queens.contains(x)) {
                canPlace = false;
                break;
            }
            x-=(n+1);
        }

        x = i - (n-1);

        while (x >= 0 && x % n <= n-1 && x % n > i % n && canPlace) {
            if (queens.contains(x)) {
                canPlace = false;
                break;
            }
            x-=(n-1);
        }



        int ans = 0;
        if (canPlace){
        queens.add(i);
        int newI = rowstart + n;
        ans += helper(queens, newI, rem-1, n);
        queens.remove(i);}

        ans += helper(queens, i+1, rem, n);


        return ans;

    }
}