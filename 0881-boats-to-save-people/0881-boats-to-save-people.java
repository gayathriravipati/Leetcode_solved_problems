class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int min_boats = 0;
        Arrays.sort(people);
        int i = 0;
        int j = people.length-1;
        System.out.println(people.length);
        while(i<j){
            // System.out.println(i + " " + j + " " + people[i] + " " + people[j]);
            if(people[i] == limit || people[j] == limit){
                if(people[i]==limit){
                    i++;
                    min_boats++;
                }
                if(people[j]==limit){
                    j--;
                    min_boats++;
                }
            }
             else if(people[i] + people[j] <= limit){
                min_boats++;
                i++;
                j--;
            }
            else if(people[i] + people[j] > limit){
                j--;
                min_boats++;
            }
            
        }
        if(i==j){
           min_boats++; 
        }
        return min_boats;
    }
}