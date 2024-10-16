import java.util.PriorityQueue;

class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> Integer.compare(y.count, x.count));
        if (a > 0) {
            pq.add(new Pair(a, 'a'));
        }
        
        if (b > 0) {
            pq.add(new Pair(b, 'b'));
        }
        
        if (c > 0) {
            pq.add(new Pair(c, 'c'));
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(!pq.isEmpty()){
            Pair current = pq.poll();
            int val = current.count;
            char t = current.ch;
            
            if(sb.length() >= 2 && sb.charAt(sb.length()-1) == t && sb.charAt(sb.length()-2) == t){
                if(pq.isEmpty()){
                    break;
                }
                Pair next = pq.poll();
                sb.append(next.ch);
                if(next.count -1 > 0){
                    pq.add(new Pair(next.count -1 , next.ch));
                }
            }
            else{
                val--;
                sb.append(t);
            }
            
            if (val > 0) {
                pq.add(new Pair(val, t));
            }
            
        }


        return sb.toString();
    }
}

class Pair {
    int count;
    char ch;
    
    Pair(int count, char ch) {
        this.count = count;
        this.ch = ch;
    }
}
