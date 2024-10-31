class Solution {
    public int lastStoneWeight(int[] stones) {
        //Max-heap
        //if size >= 2
        //poll()
        //if both equal => continue
        //max - second => add
        //return heap.peek();
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : stones){
            pq.add(i);
        }
        
        while(pq.size()>= 2){
            int maxOne = pq.poll();
            int maxTwo = pq.poll();
            
            if(maxOne == maxTwo){
                continue;
            }
            else{
                pq.add(maxOne - maxTwo);
            }
        }
        
        if(pq.size() == 1){
            return pq.poll();
        }
        
        return 0;
    }
}