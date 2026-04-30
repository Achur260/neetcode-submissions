class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int diff = 0;
        for (int i = 0; i < gas.length; i++) {
            diff += gas[i] - cost[i];
        }

        if (diff < 0) {
            return -1;
        }

        int prevIndex = 0;
        int currGas = 0;

        for (int i = 0; i < gas.length; i++) {
            int newGas = currGas + gas[i] - cost[i];
            if (newGas < 0) {
                prevIndex = i + 1;
                currGas = 0;
            } else {
                currGas = newGas;
            }
        }




        return prevIndex;
        
        
    }
}
