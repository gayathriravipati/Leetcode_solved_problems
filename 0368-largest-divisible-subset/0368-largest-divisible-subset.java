class Solution {
  public List<Integer> largestDivisibleSubset(int[] nums) {
    int n = nums.length;
    if (n == 0) return new ArrayList();
        
    List<ArrayList> EDS = new ArrayList();
    for (int num : nums) EDS.add(new ArrayList());

    Arrays.sort(nums);

    for (int i = 0; i < n; ++i) {
      List<Integer> maxSubset = new ArrayList();
            
      for (int k = 0; k < i; ++k) 
        if (nums[i] % nums[k] == 0 && maxSubset.size() < EDS.get(k).size())
          maxSubset = EDS.get(k);
          
      EDS.get(i).addAll(maxSubset);
      EDS.get(i).add(nums[i]);
    }
    
    List<Integer> ret = new ArrayList();
    for (int i = 0; i < n; ++i) 
      if (ret.size() < EDS.get(i).size()) ret = EDS.get(i);
    return ret;
  }  
}