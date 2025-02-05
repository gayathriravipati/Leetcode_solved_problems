class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }

        List<Integer> diffIndexes = new ArrayList<>();

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diffIndexes.add(i);
            }
        }

        if (diffIndexes.size() != 2) {
            return false;
        }

        int i = diffIndexes.get(0);
        int j = diffIndexes.get(1);
        return s1.charAt(i) == s2.charAt(j) && s1.charAt(j) == s2.charAt(i);
    }
}
