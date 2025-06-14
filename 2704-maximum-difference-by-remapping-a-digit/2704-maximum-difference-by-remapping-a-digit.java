class Solution {
    public int minMaxDifference(int num) {
        //min => leftmost with 0
        //max => leftmost with 9

        List<Integer> st = new ArrayList<>();
        int n = num;
        while(n > 0){
            st.add(n % 10);
            n = n / 10;
        }

        int len = st.size();
        int minRef = 0;
        int maxRef = 0;

        for(int i = len-1; i>=0; i--){
            if(st.get(i) != 9){
                maxRef = st.get(i);
                break;
            }
        }

        for(int i = len-1; i>=0; i--){
            if(st.get(i) != 0 && minRef == 0){
                minRef = st.get(i);
                break;
            }
        }

        int minNum = 0;
        int maxNum = 0;

        for(int i = len-1; i>=0; i--){
            int cv = st.get(i);
            if(cv == minRef){
                minNum = minNum * 10 + 0;
            }
            else{
                minNum = minNum * 10 + cv;
            }

            if(cv == maxRef){
                maxNum = maxNum * 10 + 9;
            }
            else{
                maxNum = maxNum * 10 + cv;
            }
        }

        // System.out.println(maxNum + " " + minNum);
        return maxNum - minNum;
        
    }
}