class Solution {
    public String simplifyPath(String path) {
        String[] subParts = path.split("/");
        
        // for(String s : subParts){
        //     System.out.println(s);
        // }
        
        StringBuilder sb = new StringBuilder();
        
        Deque<String> st = new ArrayDeque<>();
        
        for(String str : subParts){
            if(str.equals(".")|| str == null || str == ""){
                continue;
            }
            else if(str.equals("..")){
                if(st.size() > 0){
                    st.removeLast();
                }
                // System.out.println( st.removeLast()+ "!!!");
            }
            else{
                st.addLast(str);
                // System.out.println( str + "!!!");
            }
        }

        
        while(st.size() > 0){
            sb.append("/");
            String ts = st.removeFirst();
            // System.out.println(ts + "---");
            sb.append(ts);
        }
        
        // sb.remove(sb.length() - 1);
        if(sb.length() == 0){
            return "/";
        }
        
        return sb.toString();
    }
}