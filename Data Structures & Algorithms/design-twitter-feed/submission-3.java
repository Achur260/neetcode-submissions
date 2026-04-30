class Twitter {

    HashMap<Integer, List<int[]>> hm;
    HashMap<Integer, HashSet<Integer>> followMap;
    int count;


    public Twitter() {
        hm = new HashMap<>();
        followMap = new HashMap<>();
        count = 0;

        
    }
    
    public void postTweet(int userId, int tweetId) {
        hm.putIfAbsent(userId, new LinkedList<int[]>());
        followMap.putIfAbsent(userId, new HashSet<Integer>());
        hm.get(userId).addLast(new int[] {tweetId, count});
        count++;

    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((n1,n2) -> {
            return n1[1] - n2[1];
        });


        if (followMap.containsKey(userId)) {
            for (int f : followMap.get(userId)) {
                if (hm.containsKey(f) && f != userId) {
                    for (int[] tweet : hm.get(f)) {
                        pq.add(tweet);
                        if (pq.size() > 10) {
                            pq.remove();
                        }
                    }
                }
            }
        }

        if (hm.containsKey(userId)) {
            for (int[] tweet : hm.get(userId)) {
                        pq.add(tweet);
                        if (pq.size() > 10) {
                            pq.remove();
                        }
                    }
        }

        List<Integer> l = new ArrayList<>();

        while (!pq.isEmpty()) {
            l.addFirst(pq.remove()[0]);
        }

        return l;
    }
    
    public void follow(int followerId, int followeeId) {
        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        followMap.get(followerId).remove((Integer) followeeId);
    }
}
