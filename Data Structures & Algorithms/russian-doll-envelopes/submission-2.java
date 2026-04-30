class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (n1, n2) -> {
            if (n1[0] == n2[0]) {
                return n2[1] - n1[1];
            }

            return n1[0] - n2[0];
        });

        for (int[] env : envelopes) {
            System.out.print(Arrays.toString(env) + " ");
        }

        ArrayList<Integer> sub = new ArrayList<>();
        for (int[] env : envelopes) {
            if (sub.isEmpty() || env[1] > sub.getLast()) {
                sub.add(env[1]);
            } else {
                
                int i = 0;
                int j = sub.size()-1;

                int res = -1;

                while (i <= j) {
                    int mid = (i+j)/2;

                    if (sub.get(mid) == env[1]) {
                        res = mid;
                        break;
                    } else if (sub.get(mid) > env[1]) {
                        j = mid-1;
                    } else {
                        i = mid+1;
                    }
                }

                if (res == -1) {
                    sub.set(i, env[1]);
                }


            }
        }


        return sub.size();
    }
}