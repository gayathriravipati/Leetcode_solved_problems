class Solution {
    List<String> result = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    
    public List<String> generateParenthesis(int n) {
        findStrings(0,0,n);
        return result;
    }
    
    public void findStrings(int open, int closed, int limit){
        if(open == closed && open == limit){
            result.add(sb.toString());
        }
        
        if(open < limit){
            sb.append('(');
            findStrings(open+1, closed, limit);
            sb.deleteCharAt(sb.length() - 1);

        }
        
        if(closed < open){
            sb.append(')');
            findStrings(open, closed+1, limit);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}