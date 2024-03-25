class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int l = nums.length;
        int ts = (l * (l+1)) / 2;
        Set<Integer> st = new HashSet<>(); 
        for(int i=0;i<l;i++){
            if(st.contains(nums[i])){
                arrayList.add(nums[i]);
            }
            else{
                st.add(nums[i]);
            }
        }
        return arrayList;
    }
}