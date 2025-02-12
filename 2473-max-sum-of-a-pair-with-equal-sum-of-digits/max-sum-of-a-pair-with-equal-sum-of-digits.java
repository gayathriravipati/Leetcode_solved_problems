import java.util.*;

class Solution {
    public int maximumSum(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> freqMap = new HashMap<>();

        for (int num : nums) {
            int sum = digitSum(num);
            freqMap.computeIfAbsent(sum, k -> new PriorityQueue<>(Collections.reverseOrder())).add(num);
        }

        int maxSum = -1;

        for (PriorityQueue<Integer> pq : freqMap.values()) {
            if (pq.size() >= 2) {
                int firstMax = pq.poll();  
                int secondMax = pq.poll(); 
                maxSum = Math.max(maxSum, firstMax + secondMax);
            }
        }

        return maxSum;
    }

    private int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.maximumSum(new int[]{4, 6, 10, 6})); 
    }
}
