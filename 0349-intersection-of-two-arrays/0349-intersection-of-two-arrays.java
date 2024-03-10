import java.util.Arrays;
import java.util.Vector;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Vector<Integer> vector = new Vector<>();
        for (int num : nums2) {
            vector.add(num);
        }
        Vector<Integer> resultVector = new Vector<>();

        for (int i = 0; i < nums1.length; i++) {
            if (vector.contains(nums1[i]) && !resultVector.contains(nums1[i])) {
                resultVector.add(nums1[i]);
            }
        }

        return resultVector.stream().mapToInt(Integer::intValue).toArray();
    }
}
