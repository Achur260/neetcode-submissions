class MedianFinder {


    PriorityQueue<Integer> minH;
    PriorityQueue<Integer> maxH;

    public MedianFinder() {
        minH = new PriorityQueue<>((n1,n2) -> {
            return n1 - n2;
        });

        maxH = new PriorityQueue<>((n1,n2) -> {
            return n2 - n1;
        });


        
    }
    
    public void addNum(int num) {
        if (minH.size() == maxH.size()) {
            if (maxH.size() > 0 && num > minH.peek()) {
                int top = minH.remove();
                maxH.add(top);
                minH.add(num);
                
            } else {
                maxH.add(num);
            }

        } else {
            if (num > maxH.peek()) {
                minH.add(num);
                
            } else {
                maxH.add(num);
                minH.add(maxH.remove());
            }

        }
        
    }
    
    public double findMedian() {
        if (minH.size() == maxH.size()) {


            System.out.println("equal");
            return ((double)(minH.peek()+maxH.peek()))/2;
        }


        System.out.println("unequal");
        return (double) maxH.peek();
        
    }
}
