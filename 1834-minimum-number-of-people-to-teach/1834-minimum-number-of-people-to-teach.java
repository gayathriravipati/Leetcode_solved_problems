class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        Set<Integer> noBond = new HashSet<>();

        for(int[] friends : friendships){
            int friendOne = friends[0];
            int friendTwo = friends[1];

            Set<Integer> OneLanguages = new HashSet<>();
            for(int i : languages[friendOne - 1]){
                OneLanguages.add(i);
            }

            boolean status = false;
            for(int i : languages[friendTwo - 1]){
                    if(OneLanguages.contains(i)){
                        status = true;
                        break;
                    }
            }

            if(!status){
                noBond.add(friendTwo - 1);
                noBond.add(friendOne - 1);
            }
        }

        int maxCnt = 0;
        int[] langCnt = new int[n + 1];

        for(int i : noBond){
            for(int lang : languages[i]){
                langCnt[lang]++;
                maxCnt = Math.max(langCnt[lang], maxCnt);
            }
        }

        return (noBond.size() - maxCnt);
    }
}