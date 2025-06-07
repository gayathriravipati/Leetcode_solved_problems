//https://leetcode.com/problems/using-a-robot-to-print-the-lexicographically-smallest-string/solutions/6815333/cpp-java-python-greedy-100-beats-easy-to-understand/

class Solution {
    int[] freqCnt = new int[26];

    public String robotWithString(String s) {
        for(char ch : s.toCharArray()){
            freqCnt[ch-'a']++;
        }
        
        Deque<Integer> dq = new ArrayDeque<>();
        StringBuilder res = new StringBuilder();
        //Iterating through the array
        for(char ch : s.toCharArray()){
            dq.addLast(ch-'a');
            freqCnt[ch - 'a']--; 

            //Check if there is a smallest character than the current element
            while(!dq.isEmpty() && !hasSmaller(dq.peekLast())){

                res.append((char) (dq.removeLast() + 'a'));  

            }
        }

        return res.toString();
    }

    public boolean hasSmaller(int top){
        for(int i=0; i<top; i++){
            if(freqCnt[i] > 0){
                return true;
            }
        }
        return false;
    }

}