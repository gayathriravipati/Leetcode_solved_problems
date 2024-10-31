class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char ch : tasks){
            freq[ch - 'A']++;
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : freq){
            if(i > 0){
                pq.add(i);
            }
        }
        
        int time = 0;
        while(!pq.isEmpty()){
            int cycle = n+1;
            List<Integer> store = new ArrayList<>();
            int taskCount = 0;
            
            while(cycle-- > 0 && !pq.isEmpty()){
                int val = pq.poll();
                if(val > 1){
                    store.add(val-1);
                }
                taskCount++;
            }
            
            if(store.size() > 0){
                store.forEach(pq::offer);
            }
            
            time += (pq.isEmpty() ? taskCount : n + 1);   
        }
        return time;
    }
}