/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {

        for (int i = 0; i < n; i++) {
            boolean kn = true;
            for (int j = 0; j < n; j++) {
                if (j != i && knows(i, j)) {
                    kn = false ;
                    break;
                }
            }

            if (kn) {
                for (int j = 0; j < n; j++) {
                    if (j != i && !knows(j,i)) {
                        kn = false;
                        break;
                    }
                }
            }

            if (kn) {
                return i;
            }
        }



        return -1;
        
    }
}
