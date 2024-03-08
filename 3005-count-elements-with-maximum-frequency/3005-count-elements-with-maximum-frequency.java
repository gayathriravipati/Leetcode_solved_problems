class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> frequencies = new HashMap<>();
        int maxFrequency = 0;
        for (int num : nums) {
            int frequency = frequencies.getOrDefault(num, 0) + 1;
            frequencies.put(num, frequency);
            if (frequency > maxFrequency) {
                maxFrequency = frequency;
            }
        }
        
        int frequencyOfMaxFrequency = 0;
        for (int frequency : frequencies.values()) {
            if (frequency == maxFrequency) {
                frequencyOfMaxFrequency++;
            }
        }
        
        return frequencyOfMaxFrequency * maxFrequency;
    }
}