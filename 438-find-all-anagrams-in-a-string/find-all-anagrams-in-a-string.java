class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        
        if(sLen < pLen){
            return new ArrayList<>();
        }
        
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> pFreq = new HashMap<>();
        Map<Character, Integer> sFreq;
        
        //HashMap - p
        for(int i=0; i<pLen; i++){
            pFreq.put(p.charAt(i), pFreq.getOrDefault(p.charAt(i), 0)+1);
        }
        
        int i=0, j=0;
        sFreq = new HashMap<>();
        
        while(j < sLen){
            
           if(pFreq.containsKey(s.charAt(j))){
               sFreq.put(s.charAt(j), sFreq.getOrDefault(s.charAt(j), 0) + 1);
               
               while(pFreq.get(s.charAt(j)) <  sFreq.get(s.charAt(j))){
                   sFreq.put(s.charAt(i), sFreq.get(s.charAt(i)) - 1);
                   i++;
               }
               
               if(pFreq.size() == sFreq.size()){
                   if(isMapEqual(pFreq, sFreq)){
                       res.add(i);
                       sFreq.put(s.charAt(i), sFreq.get(s.charAt(i)) - 1);
                       i++;
                   }
               }
           }
              else{
                i = j+1;
                sFreq = new HashMap<>();
              }
            j++;
      }
        return res;
    }
    
    private boolean isMapEqual(Map<Character, Integer> map1, Map<Character, Integer> map2){
        if (map1.size() != map2.size()) {
            return false;
        }
        for (Character key : map1.keySet()) {
            if (!map2.containsKey(key) || !map2.get(key).equals(map1.get(key))) {
                return false;
            }
        }
        return true;
    }
}


// c - 1
// b - 1
// a - 1
//     0,

// i - 5
// a-1, b-1, c-1