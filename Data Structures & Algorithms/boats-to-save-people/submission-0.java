class Solution {
    public int numRescueBoats(int[] people, int limit) {
        
        Arrays.sort(people);

        int i = 0;
        int j = people.length-1;
        int b = 0;

        while (i <= j) {
            int rem = limit-people[j];
            j--;
            b++;

            if (rem >= people[i]) {
                i++;
            }
        }

        return b;
    }
}