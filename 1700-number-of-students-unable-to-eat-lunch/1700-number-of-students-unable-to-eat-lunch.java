class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<students.length;i++){
            q.add(students[i]);
        }
        
        Stack<Integer> st = new Stack<>();
        for(int i=sandwiches.length-1;i>=0;i--){
            st.add(sandwiches[i]);
        }
        
        int s = q.size();
        int f = 0;
        int c = 0;
        while(!q.isEmpty() && !st.isEmpty()){
            int sp = q.peek();
            int stype = st.peek();
            // System.out.println(sp + " " + stype + " " + "elem");
            
            if(sp==stype){
                q.remove();
                st.pop();
                c=0;
                // System.out.println(sp + " " + stype + " " + c + " " + "pop");
            }
            else{
                c++;
                q.remove();
                q.add(sp);
                // System.out.println(sp + " " + stype + " " + c);
                if(c==q.size()){
                    return q.size();
                }
            }
        }
        return c;
    }
}