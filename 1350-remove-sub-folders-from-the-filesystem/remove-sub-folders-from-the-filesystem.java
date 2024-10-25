class TrieNode {
        boolean isEnd;
        HashMap<String, TrieNode> children;

        TrieNode() {
            isEnd = false;
            children = new HashMap<>();
        }
}

class Solution {
    public List<String> removeSubfolders(String[] folder) {
        TrieNode root = new TrieNode();
        for (String path : folder) {
            TrieNode currentNode = root;
            String[] folderNames = path.split("/");
             for (String folderName : folderNames) {
                   if (folderName.equals("")) continue;
                  if (!currentNode.children.containsKey(folderName)) {
                    currentNode.children.put(folderName, new TrieNode());
                }
                 currentNode = currentNode.children.get(folderName);
             }
            currentNode.isEnd = true;
        }
        
        List<String> result = new ArrayList<>();
    for (String path : folder) {
        TrieNode currentNode = root;
        String[] folderNames = path.split("/");
         boolean isSubfolder = false;
        for (int i = 0; i < folderNames.length; i++) {
            if (folderNames[i].equals("")) continue;
            TrieNode nextNode = currentNode.children.get(folderNames[i]);
            if (nextNode.isEnd && i != folderNames.length - 1) {
                    isSubfolder = true;
                    break; 
                }

                currentNode = nextNode;
            }
            if (!isSubfolder) result.add(path);
        }

        return result;
        }
    }
    
    
    
    