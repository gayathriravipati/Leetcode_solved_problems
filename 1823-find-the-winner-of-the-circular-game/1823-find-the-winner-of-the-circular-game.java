class Solution {
    public int findTheWinner(int n, int k) {
        Deque<Integer> friends = new LinkedList<>();
        
        for(int i = 1; i<=n; i++){
            friends.add(i);
        }
        
        
        while(friends.size() > 1){
            int val = k;
            
            while(val > 1 && friends.size() > 1){
                int v = friends.getFirst();
                friends.removeFirst();
                friends.addLast(v);
                val--;
            }
            
            friends.removeFirst();
        }
        
        return friends.getFirst();
    }
}