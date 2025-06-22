class RecentCounter {
    Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.add(t);
        while (queue.peek() < t - 3000) {
            queue.poll();  
            // remove pings outside the 3000ms window -- this is because it is mentioned in the question that every next ping is higher than the previous one.
        }
        return queue.size();
    }
}
