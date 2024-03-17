class Solution {
    public boolean isSubstringPresent(String s) {
        int n = s.length();
        
        for (int i = 0; i < n - 1; i++) {
            String substr = s.substring(i, i + 2); 
            String reversed = new StringBuilder(substr).reverse().toString(); 
            
            if (s.indexOf(reversed) != -1) {
                return true; 
            }
        }
        
        return false; 
    }
}
