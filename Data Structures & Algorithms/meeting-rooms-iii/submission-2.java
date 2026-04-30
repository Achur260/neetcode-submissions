class Solution {
    public int mostBooked(int n, int[][] meetings) {
        

        int[] roomCounts = new int[n];
        int[] roomLast = new int[n];
        int max = 0;

        Arrays.sort(meetings, (n1,n2) -> {
            return n1[0] - n2[0];
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> {
            if (roomLast[n1] == roomLast[n2]) {
                return n1-n2;
            }

            return roomLast[n1] - roomLast[n2];
        });


        for (int i = 0; i < n; i++) {
            pq.add(i);
        }


        int currStartTime = 0;

        int trueCount = 0;
        int trueMax = 0;

        for (int[] meeting : meetings) {

            // System.out.println(Arrays.toString(meeting));
            // System.out.println(Arrays.toString(roomCounts));
            // System.out.println(Arrays.toString(roomLast));
            // System.out.println(currStartTime);
            // System.out.println(trueMax + " " + trueCount);
            // System.out.println();
            currStartTime = Math.max(currStartTime, meeting[0]);
            int diff = meeting[1] - meeting[0];

            HashSet<Integer> hs = new HashSet<>();

            while (!pq.isEmpty() && roomLast[pq.peek()] < currStartTime) {
                roomLast[pq.peek()] = 0;
                hs.add(pq.remove());
            }

            for (int r : hs) {
                pq.add(r);
            }

            int maxRoom = pq.peek();
            int maxEnd = roomLast[maxRoom];

            currStartTime = Math.max(currStartTime, maxEnd);
            roomLast[maxRoom] = currStartTime + diff;
            roomCounts[maxRoom]++;


            if (trueCount < roomCounts[maxRoom]) {
                trueCount = roomCounts[maxRoom];
                trueMax = maxRoom;
            } else if (trueCount == roomCounts[maxRoom]) {
                trueMax = Math.min(trueMax, maxRoom);
            }

            pq.remove();

            pq.add(maxRoom);

            
            
        }

        return trueMax;




    }
}