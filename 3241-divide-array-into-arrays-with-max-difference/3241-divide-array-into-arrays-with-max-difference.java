class Solution {
    public int[][] divideArray(int[] nums, int k) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int idx = 0;
        int len = nums.length;
        List<Integer> temp;

        while (idx < len - 2) {
            temp = new ArrayList<>();
            int element = nums[idx];
            for (int i = idx; i < idx + 3; i++) {
                if (nums[i] - element <= k) {
                    temp.add(nums[i]);
                } else {
                    return new int[0][0];
                }
            }
            idx += 3;
            result.add(temp);
        }

        int[][] resArray = new int[result.size()][3];
        for (int i = 0; i < result.size(); i++) {
            List<Integer> row = result.get(i);
            for (int j = 0; j < 3; j++) {
                resArray[i][j] = row.get(j);
            }
        }

        return resArray;
    }
}
