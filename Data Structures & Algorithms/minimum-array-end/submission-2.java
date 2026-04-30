class Solution {
    public long minEnd(int n, int x) {

        long prev = x;

        long rem = n-1;

        int i = 0;

        while (rem > 0 && i <= 64) {

        

            long curr = rem & 1;

            long currZ = (prev >> i) & 1;

            if (currZ == 0) {
                prev = prev | curr << i;
                rem = rem >> 1;
            }

            i++;
            
        }


        return prev;


        
    }
}