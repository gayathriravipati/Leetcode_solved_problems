class Solution {
    public List<String> partitionString(String s) {
        Set<String> uniqueSegments = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        List<String> res =  new ArrayList<>();
        sb.append(s.charAt(0));

        for(int i = 1; i<s.length(); i++){
            if(!uniqueSegments.contains(sb.toString())){
                // System.out.println(sb + " " + "add");
                uniqueSegments.add(sb.toString());
                res.add(sb.toString());
                sb.setLength(0);
                sb.append(s.charAt(i));
                // System.out.println(sb + " " + "sb");
            }
            else{
                sb.append(s.charAt(i));
                // System.out.println(sb + " " + "sb");
            }
        }

        if(sb.length() > 0 && !uniqueSegments.contains(sb.toString())){
            uniqueSegments.add(sb.toString());
            res.add(sb.toString());
        }

        // for(String st : uniqueSegments){
        //     res.add(st);
        // }

        // Collections.sort(res);

        return res;
    }
}