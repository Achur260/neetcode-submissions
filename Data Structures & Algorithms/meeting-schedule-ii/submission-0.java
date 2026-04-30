/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {

        int maxRooms = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((n1,n2) -> {
            return n1-n2;
        });

        intervals.sort((n1,n2) -> {
            return n1.start - n2.start;
        });

        for (Interval interval : intervals) {
            while (!pq.isEmpty() && interval.start >= pq.peek()) {
                pq.remove();
            }

            pq.add(interval.end);
            maxRooms = Math.max(maxRooms, pq.size());
        }

        return maxRooms;

    }
}
