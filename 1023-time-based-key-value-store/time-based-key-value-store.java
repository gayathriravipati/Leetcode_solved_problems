class TimeMap {
    private HashMap<String, List<Pair<Integer, String>>> valueMap;
    
    public TimeMap() {
       valueMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        valueMap.computeIfAbsent(key, k-> new ArrayList<>()).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if (!valueMap.containsKey(key)) {
            return "";
        } else {
            List<Pair<Integer, String>> storedVal = valueMap.get(key);

            int left = 0, right = storedVal.size() - 1;
            String res = "";
            
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (storedVal.get(mid).getKey() <= timestamp) {
                    res = storedVal.get(mid).getValue();
                    left = mid + 1; 
                } else {
                    right = mid - 1;
                }
            }
            
            return res;
        }
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */