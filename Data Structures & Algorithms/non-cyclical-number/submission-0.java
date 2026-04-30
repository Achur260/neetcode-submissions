class Solution {
    public boolean isHappy(int n) {
        
        HashSet<Integer> hs = new HashSet<>();

        int curr = n;

        while (!hs.contains(curr)) {
            hs.add(curr);
            int s = 0;
            while (curr > 0) {
                int m = curr % 10;
                s += m*m;
                curr/=10;
            }

            if (s==1)
                return true;
            
            curr = s;
        }

        return false;
    }
}
