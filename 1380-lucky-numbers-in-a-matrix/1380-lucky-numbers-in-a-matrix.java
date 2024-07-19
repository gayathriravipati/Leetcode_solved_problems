class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int rows = matrix.length;
        int columns = matrix[0].length;
        
        for(int i = 0; i<rows; i++){
            int min_ele = Integer.MAX_VALUE;
            int min_ele_col = -1;
            for(int j=0; j<columns; j++){
                if(matrix[i][j] < min_ele){
                    min_ele = matrix[i][j];
                    min_ele_col = j;
                }
            }
            
            int max_ele = Integer.MIN_VALUE;
            for(int k = 0; k<rows; k++){
                if(matrix[k][min_ele_col] > max_ele){
                    max_ele = matrix[k][min_ele_col];
                }
            }
            
            if(max_ele==min_ele){
                result.add(min_ele);
            }
        }
        
        return result;
    }
}