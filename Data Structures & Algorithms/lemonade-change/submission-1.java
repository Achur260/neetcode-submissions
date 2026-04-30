class Solution {
    public boolean lemonadeChange(int[] bills) {
        
        int fives = 0;
        int tens = 0;
        int twenties = 0;

        for (int bill : bills) {
            int rem = bill - 5;
            if (rem == 0) {
                fives++;
            } else if (rem == 5) {
                if (fives == 0) {
                    return false;
                }

                fives--;
                tens++;
            } else if (rem == 15) {
                boolean x = tens == 0 && fives < 3;
                boolean y = tens > 0 && fives < 1;

                if (x || y) {
                    return false;
                }

                if (tens == 0) {
                    fives -= 3;
                    twenties += 1;
                }

                else if (tens > 0) {
                    fives -=1;
                    tens -= 1;
                    twenties +=1;
                }
            }

        }

        return true;
    }
}