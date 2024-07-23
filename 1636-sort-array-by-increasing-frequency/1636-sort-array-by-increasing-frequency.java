class Solution {
    public int[] frequencySort(int[] nums) {
                Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        List<Pair<Integer, Integer>> pairList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            pairList.add(new Pair<>(entry.getValue(), entry.getKey()));
        }

        pairList.sort((a, b) -> {
            if (!a.getKey().equals(b.getKey())) {
                return Integer.compare(a.getKey(), b.getKey());
            } else {
                return Integer.compare(b.getValue(), a.getValue());
            }
        });

        int index = 0;
        for (Pair<Integer, Integer> pair : pairList) {
            int freq = pair.getKey();
            int val = pair.getValue();
            for (int i = 0; i < freq; i++) {
                nums[index++] = val;
            }
        }

        return nums;
    }
}