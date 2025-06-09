class Solution {

    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        for(int i=1; i<=9; i++){
            if(i <= n){
                dfs(i, n, result);
            }
        }
        return result;
    }

    public void dfs(int startNum, int limit, List<Integer> result){
        if(startNum > limit){
            return;
        }
        else{
            // System.out.println(startNum);
            result.add(startNum);
            for(int i=0; i<=9; i++){
                int nextNum = startNum * 10 + i;
                dfs(nextNum, limit, result);
            }
        }
    }
}