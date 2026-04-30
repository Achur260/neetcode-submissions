class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        ArrayList<int[]> arr = new ArrayList<>();
        Arrays.sort(intervals, (n1,n2) -> {
            if (n1[0] == n2[0]) {
                return n1[1] - n2[1];
            }

            return n1[0] - n2[0];
        });

        
        int i = 0;
        boolean done = false;
        while (i < intervals.length) {
            
            if (!done) {
                if (newInterval[0] < intervals[i][0]) {

                    if (arr.isEmpty() || arr.get(arr.size() - 1)[1] < newInterval[0])
                        arr.add(newInterval);
                    else {
                        arr.set(arr.size() - 1, new int[]{arr.get(arr.size() - 1)[0], Math.max(arr.get(arr.size() - 1)[1], newInterval[1])});
                    }
                    done = true;
                } else {
                    arr.add(intervals[i]);
                    i++;
                }

            } else {
                int[] top = arr.get(arr.size()-1);

                if (intervals[i][0] <= top[1]) {
                    arr.set(arr.size()-1, new int[]{top[0], Math.max(top[1], intervals[i][1])});
                } else {
                    arr.add(intervals[i]);
                }

                i++;
            }
        
        
        
        }

        

        if (!done) {


            System.out.println("happened");


                if (!arr.isEmpty() && newInterval[0] <= arr.get(arr.size()-1)[1]) {
                    int[] top = arr.get(arr.size()-1);
                    arr.set(arr.size()-1, new int[]{top[0], Math.max(top[1], newInterval[1])});
                } else {
                    arr.add(newInterval);
                }

                i++;
            
        }


        


        int[][] ans = new int[arr.size()][];
        for (int j = 0; j < ans.length; j++) {
            ans[j] = arr.get(j);
        }

        return ans;
    }
}
