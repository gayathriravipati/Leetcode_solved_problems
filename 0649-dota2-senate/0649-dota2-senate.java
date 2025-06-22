class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> rq = new ArrayDeque<>();
        Queue<Integer> dq = new ArrayDeque<>();
        int len = senate.length();

        for(int i=0; i<len; i++){
            if(senate.charAt(i) == 'R'){
                rq.add(i);
            }
            else{
                dq.add(i);
            }
        }

        while(!rq.isEmpty() && !dq.isEmpty()){
            int rval = rq.poll();
            int dval = dq.poll();

            if(rval < dval){
                rq.add(rval + len);
            }
            else{
                dq.add(dval + len);
            }
        }

        return dq.size() > 0 ? "Dire" :  "Radiant";

    }
}