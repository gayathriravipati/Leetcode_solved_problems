class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;
        
        char[][] copyMat = new char[n][m];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                copyMat[i][j] = box[j][i];
            }
        }
        
        //reverse the chars
        // rows - n , cols - m
        for(int i=0; i<n; i++){
            for(int j=0; j<m/2; j++){
                char t = copyMat[i][m-j-1];
                copyMat[i][m-j-1] = copyMat[i][j];
                copyMat[i][j] = t;
            }
        }
        
        //Iterate through every column and find the empty space for swap;
        
        for(int i=0; i<m; i++){
            
            int lowestPoint = -1;
            
            for(int j = n-1; j>=0; j--){
                
                if(copyMat[j][i] == '.' && lowestPoint == -1){
                    lowestPoint = j;
                }
                
                else if(copyMat[j][i] == '#' && lowestPoint != -1){
                    copyMat[lowestPoint][i] ='#';
                    copyMat[j][i] ='.';
                    lowestPoint--;
                }
                
                else if (copyMat[j][i] == '*'){
                    lowestPoint = -1;
                }
            }
        }
        return copyMat;
    }
}