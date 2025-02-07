class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer, Integer> colorCountMap = new HashMap<>();
        Map<Integer, Integer> indexColorMap = new HashMap<>();
        int[] uniquecolor = new int[queries.length];
        
        for (int i = 0; i < queries.length; i++) {
            int index = queries[i][0];
            int color = queries[i][1];
            
            if (indexColorMap.containsKey(index)) {
                int oldColor = indexColorMap.get(index);
                int oldColorCount = colorCountMap.get(oldColor);
                
                if (oldColorCount - 1 == 0) {
                    colorCountMap.remove(oldColor);
                } else {
                    colorCountMap.put(oldColor, oldColorCount - 1);
                }
            }
            
            indexColorMap.put(index, color);
            colorCountMap.put(color, colorCountMap.getOrDefault(color, 0) + 1);
            
            uniquecolor[i] = colorCountMap.size();
        }
        
        return uniquecolor;
    }
}
