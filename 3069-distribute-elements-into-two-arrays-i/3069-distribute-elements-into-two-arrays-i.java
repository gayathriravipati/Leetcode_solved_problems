import java.util.Vector;

class Solution {
    public int[] resultArray(int[] nums) {
        Vector<Integer> vector1 = new Vector<>();
        Vector<Integer> vector2 = new Vector<>();
        vector1.add(nums[0]);
        vector2.add(nums[1]);
        int a, b;
        for (int i = 2; i < nums.length; i++) {
            a = vector1.lastElement();
            b = vector2.lastElement();
            if (a > b) {
                vector1.add(nums[i]);
            } else {
                vector2.add(nums[i]);
            }
        }

        int[] myArray = new int[nums.length];
        for (int i = 0; i < vector1.size(); i++) {
            myArray[i] = vector1.get(i);
        }

        for (int i = 0; i < vector2.size(); i++) {
            myArray[vector1.size() + i] = vector2.get(i);
        }

        return myArray;

    }
}
