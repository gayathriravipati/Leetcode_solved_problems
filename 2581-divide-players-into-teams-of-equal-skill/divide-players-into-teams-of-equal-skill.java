class Solution {
    public long dividePlayers(int[] skill) {
        int len = skill.length;
        Arrays.sort(skill);
        int globalChem = skill[0] + skill[len-1];
        System.out.println(globalChem);
        int i=0, j = len -1;
        long compSum = 0;
        
        while(i < j){
            if(skill[i] + skill[j] == globalChem){
                compSum += (skill[i] * skill[j]);
            }
            else{
                return -1;
            }
            i++;
            j--;
        }
        return compSum;
    }
}