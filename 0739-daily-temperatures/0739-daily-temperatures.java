class Pair<U, V> {
    public final U first;
    public final V second;

    public Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] res = new int[length];

        Stack<Pair<Integer, Integer>> st = new Stack<>();

        st.push(new Pair<>(0, temperatures[0]));

        for(int i=1; i<length; i++){
            while(!st.isEmpty() && st.peek().second < temperatures[i]){
                Pair<Integer, Integer> current = st.pop();
                int idx = current.first;
                res[idx] = i - idx;
            }
            st.push(new Pair<>(i, temperatures[i]));
        }

        
        return res;
    }
}