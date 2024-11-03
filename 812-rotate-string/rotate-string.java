class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()){
            return false;
        }
        
        String rs = s + s;
        
        for(int i=0; i< rs.length(); i++){
            int j=0;
            int k = i;
            if(rs.charAt(k) == goal.charAt(j)){
                while(k < rs.length() && j < goal.length()){
                    if(rs.charAt(k) == goal.charAt(j)){
                        System.out.println(k + " " + j);
                        k++;
                        j++;
                    }
                    else{
                        break;
                    }
                }
                     if(j == goal.length()){
                        System.out.println(j);
                        return true;
                    }
                }
            }
        
        return false;
    }
}