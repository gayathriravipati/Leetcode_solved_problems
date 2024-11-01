class Solution {
    public boolean isRobotBounded(String instructions) {
        int X = 0;
        int Y = 0;
        int dirX = 0;
        int dirY = 1;
        
        for(char ch : instructions.toCharArray()){
            if(ch == 'G'){
                X = X + dirX;
                Y = Y + dirY;
            }
            else if(ch == 'L'){
                int t = dirX;
                dirX = -1 * dirY;
                dirY = t;
            }
            else{
                int t = dirX;
                dirX =  dirY;
                dirY = -1 * t;
            }
        }
        
        if(X == 0 && Y==0){
            return true;
        }
        else{
            if(dirX != 0 || dirY != 1){
                return true;
            }
        }
        
        return false;
    }
}