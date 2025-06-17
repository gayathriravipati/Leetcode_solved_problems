class Solution {
    public int equalPairs(int[][] grid) {
        Map<List<Integer>, Integer> rows = new HashMap<>();
        List<Integer> currRow;

        //All the rows will be added to the set
        for(int i=0; i<grid.length; i++){
            currRow = new ArrayList<>();
            for(int j=0; j<grid[0].length; j++){
                currRow.add(grid[i][j]);
            }
            rows.put(currRow, rows.getOrDefault(currRow, 0) + 1);
        }

        //Now lets find each column in similar way,
        //check if its in set and increment cnt;
        int cnt = 0;
        for(int i=0; i<grid[0].length; i++){
            currRow = new ArrayList<>();
            for(int j=0; j<grid.length; j++){
                currRow.add(grid[j][i]);
            }
            if(rows.containsKey(currRow)){
                cnt += rows.get(currRow);
            }
        }
        return cnt;
    }
}