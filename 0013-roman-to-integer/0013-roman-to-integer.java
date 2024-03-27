class Solution {
    public int romanToInt(String s) {
        Map<String, Integer> mp = new HashMap<>();
        mp.put("I", 1);
        mp.put("V",5);
        mp.put("X",10);
        mp.put("L",50);
        mp.put("C",100);
        mp.put("D",500);
        mp.put("M",1000);
        mp.put("IV",4);
        mp.put("IX",9);
        mp.put("XL",40);
        mp.put("XC",90);
        mp.put("CD",400);
        mp.put("CM",900);
        
       int l = s.length();
        int sum = 0;
        for (int i = 0; i < l; i++) {
            if (i < l - 1 && mp.containsKey(s.substring(i, i + 2))) {
                sum += mp.get(s.substring(i, i + 2));
                i++;
            } else {
                sum += mp.get(s.substring(i, i + 1));
            }
        }
        return sum;
    }
}