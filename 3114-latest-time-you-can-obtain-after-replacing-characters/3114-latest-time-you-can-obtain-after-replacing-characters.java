class Solution {
    public String findLatestTime(String s) {
        
        StringBuilder str = new StringBuilder("");

        int i = 0;
        if(s.charAt(i) == '?'){
            if(s.charAt(i+1) == '?'){
               str.append('1'); 
               str.append('1'); 
               i++;
            }
            else if(s.charAt(i+1) == '0' || s.charAt(i+1) == '1'){
               str.append('1'); 
            }
            else{
                str.append('0'); 
            }
            i++;
        }
        else{
            str.append(s.charAt(i));
            i++;
        }
        
        
        
        while(i<5){
            
            if(i==1){
                if(s.charAt(i) == '?'){
                    if(str.charAt(i-1) == '1'){
                        str.append('1'); 
                     }
                    else{
                        str.append('9'); 
                    }
                }
                else{
                    str.append(s.charAt(i));
                }
            }
            
            
            
            
            else if(i==3){
                if(s.charAt(i) == '?'){
                    str.append('5'); 
                }
                else{
                   str.append(s.charAt(i)); 
                }
            }
            
            
            else if(i==2){
                 str.append(':'); 
            }
            
            
             else if(i==4){
                if(s.charAt(i) == '?'){
                    str.append('9'); 
                }
                else{
                   str.append(s.charAt(i)); 
                }
            }
            
            i++;
        }
        
        return str.toString();
        
    }
}