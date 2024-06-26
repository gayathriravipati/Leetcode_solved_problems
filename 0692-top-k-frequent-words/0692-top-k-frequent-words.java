class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> mp = new HashMap<>();
        
        for(int i=0; i<words.length; i++){
            mp.put(words[i], mp.getOrDefault(words[i], 0)+1);
        }
        
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(
            k, (a, b) -> a.getValue().equals(b.getValue()) 
            ? b.getKey().compareTo(a.getKey()) 
            : a.getValue() - b.getValue()
        );

        for (Map.Entry<String, Integer> entry : mp.entrySet()) {
            if (minHeap.size() < k) {
                minHeap.offer(entry);
            } else if (entry.getValue() > minHeap.peek().getValue() || 
                       (entry.getValue().equals(minHeap.peek().getValue()) && 
                        entry.getKey().compareTo(minHeap.peek().getKey()) < 0)) {
                minHeap.poll();
                minHeap.offer(entry);
            }
        }
        
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll().getKey());
        }
        Collections.reverse(result);
        
        return result;
    }

}