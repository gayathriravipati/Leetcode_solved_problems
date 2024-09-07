class Solution {
    public String reorganizeString(String s) {
      Map<Character, Integer> charCount = new HashMap<>();
        
      for(int i=0; i<s.length(); i++){
         charCount.put(s.charAt(i), charCount.getOrDefault(s.charAt(i), 0) + 1);
      }
        
      
      PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>( (a, b) -> b.getValue() - a.getValue());
      maxHeap.addAll(charCount.entrySet());

      var sb = new StringBuilder();    
      while(!maxHeap.isEmpty()){
          var first = maxHeap.poll();
          if (sb.length() == 0 || first.getKey() != sb.charAt(sb.length() - 1)) {
                sb.append(first.getKey());
                 if (first.getValue() > 1) {
                    first.setValue(first.getValue() - 1);
                    maxHeap.offer(first);
                }
          }
          else{
              if (maxHeap.isEmpty()) {
                    return "";
                }
              var second = maxHeap.poll();
              sb.append(second.getKey());
              if (second.getValue() > 1) {
                    second.setValue(second.getValue() - 1);
                    maxHeap.offer(second);
                }
              maxHeap.offer(first);
          }
    }
        return sb.toString();
}
}