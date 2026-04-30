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
    public boolean canAttendMeetings(List<Interval> intervals) {

        intervals.sort((n1,n2) -> {
            if (n1.start == n2.start) {
                return n1.end - n2.end;
            }
            return n1.start - n2.start;
        });

        Stack<Integer> times = new Stack<Integer>();

        for (Interval interval : intervals) {
            System.out.println(interval.start + " " + interval.end);
            System.out.println("stack");
            while (!times.isEmpty()) {
                System.out.println(times.peek());
                if (interval.start >= times.peek()) {
                    times.pop();
                } else {
                    return false;
                }

                
            }

            times.push(interval.end);
        }

        return true;


    }
}
