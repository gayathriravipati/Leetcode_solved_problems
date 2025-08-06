class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>(Arrays.asList(1)));

        if (numRows == 1) {
            return res;
        }

        res.add(new ArrayList<>(Arrays.asList(1, 1)));
        if (numRows == 2) {
            return res;
        }


        for(int i = 3; i<=numRows; i++){
            List<Integer> currRow = new ArrayList<>();
            List<Integer> prevRow = res.get(i-2);
            currRow.add(1);
            for(int j=0; j<prevRow.size()-1; j++){
                int v = prevRow.get(j) + prevRow.get(j+1);
                currRow.add(v);
            }
            currRow.add(1);
            res.add(currRow);
        }
        return res;   
    }
}