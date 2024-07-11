class Solution {
    public int minOperations(String[] logs) {
        Stack<String> trackLogs = new Stack<>();
        int i = 0;
        while (i < logs.length) {
            if (logs[i].equals("./")) {
                i++;
                continue;
            } else if (logs[i].equals("../")) {
                if (!trackLogs.isEmpty()) {
                    trackLogs.pop();
                }
            } else {
                trackLogs.push(logs[i]);
            }
            i++;
        }
        return trackLogs.size();
    }
}
