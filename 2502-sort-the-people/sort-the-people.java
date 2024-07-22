class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        List<Pair<Integer, String>> pairList = new ArrayList<>();
        
        for (int i = 0; i < names.length; i++) {
            pairList.add(new Pair<>(heights[i], names[i]));
        }
        
        pairList.sort(Comparator.<Pair<Integer, String>, Integer>comparing(Pair::getKey).reversed());
        
        String[] result = new String[names.length];
        int index = 0;
        for (Pair<Integer, String> pair : pairList) {
            result[index++] = pair.getValue();
        }
        
        return result;
    }
}