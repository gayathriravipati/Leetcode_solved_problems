class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;

        for (int i = 0; i < len; i++) {
            if (flowerbed[i] == 1) continue;

            //Learnt abt Java short-circuit method, if first condition in || is true, it doesn't evaluate the second condition which helps in avoiding the array out of bounds error.
            boolean left = (i == 0 || flowerbed[i - 1] == 0);
            boolean right = (i == len - 1 || flowerbed[i + 1] == 0);

            if (left && right) {
                flowerbed[i] = 1;
                n--;
                if (n == 0) return true;
            }
        }

        return n <= 0;
    }
}
