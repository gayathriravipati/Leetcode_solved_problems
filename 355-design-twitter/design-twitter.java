class Twitter {
    Map<Integer, Set<Integer>> followerList; // Use Set to avoid duplicate follow relationships
    Map<Integer, List<int[]>> userTweets; // List<int[]>: {currentTweetNum, tweetId}
    int currentTweetNum;
        
    public Twitter() {
        followerList = new HashMap<>();
        userTweets = new HashMap<>();
        currentTweetNum = 1;
    }
    
    public void postTweet(int userId, int tweetId) {
        userTweets.computeIfAbsent(userId, k -> new ArrayList<>()).add(new int[]{currentTweetNum, tweetId});
        currentTweetNum++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> latestFeed = new PriorityQueue<>(
            (a, b) -> Integer.compare(b[0], a[0]) // Sort by currentTweetNum in descending order
        );
        List<Integer> tweetNumbers = new ArrayList<>();
        
        Set<Integer> friends = new HashSet<>(followerList.getOrDefault(userId, new HashSet<>()));
        friends.add(userId); // Always include user's own tweets
        
        // Iterate through friends and add their tweets to the priority queue
        for (int friendId : friends) {
            List<int[]> individualTweets = userTweets.getOrDefault(friendId, new ArrayList<>());
            latestFeed.addAll(individualTweets);
        }
        
        int cnt = 0;
        while (cnt < 10 && !latestFeed.isEmpty()) {
            tweetNumbers.add(latestFeed.poll()[1]); // Extract tweetId
            cnt++;
        }
        return tweetNumbers;
    }
    
    public void follow(int followerId, int followeeId) {
        if (followerId != followeeId) { // Avoid self-following
            followerList.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followees = followerList.get(followerId);
        if (followees != null) {
            followees.remove(followeeId);
        }
    }
}
