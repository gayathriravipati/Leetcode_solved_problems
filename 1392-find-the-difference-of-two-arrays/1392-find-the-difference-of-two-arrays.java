class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> collectiveList = new ArrayList<>();
        List<Integer> firstList = new ArrayList<>();
        List<Integer> secondList = new ArrayList<>();

        Map<Integer, Set<Integer>> mp = new HashMap<>();

        int i=0, j=0;
        int oneLen = nums1.length, twoLen = nums2.length;
        while(i < oneLen && j < twoLen){
            mp.computeIfAbsent(nums1[i], k -> new HashSet<>()).add(1);
            mp.computeIfAbsent(nums2[j], k -> new HashSet<>()).add(2);
            i++;
            j++;
        }

        while(i < oneLen){
            mp.computeIfAbsent(nums1[i], k -> new HashSet<>()).add(1);
            i++;
        }

        while(j < twoLen){
            mp.computeIfAbsent(nums2[j], k -> new HashSet<>()).add(2);
            j++;
        }

        for(Map.Entry<Integer, Set<Integer>> itr : mp.entrySet()){
            int num = itr.getKey();
            Set<Integer> positions = itr.getValue();
            if(positions.size() == 2){
                continue;
            }

            for(int v : positions){
                if(v==1){
                    firstList.add(num);
                }
                else{
                    secondList.add(num);
                }
            }
        }
        collectiveList.add(firstList);
        collectiveList.add(secondList);
        return collectiveList;
    }
}