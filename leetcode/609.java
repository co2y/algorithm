class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<FileInfo>> content2File = new HashMap<>();
        
        for (String path : paths) {
            getInfo(content2File ,path);
        }
        
        List<List<String>> ans = new ArrayList<>();
        
        for (Map.Entry<String, List<FileInfo>> entry : content2File.entrySet()) {
            if (entry.getValue().size() > 1) {
                List<String> a = new ArrayList<>();
                for (FileInfo f : entry.getValue()) {
                    a.add(f.path + "/" + f.fileName);
                }
                ans.add(a);
            }
        }
        
        return ans;
    }
    
    private void getInfo(Map<String, List<FileInfo>> content2File, String path) {
        String[] token = path.split(" ");
        String p = token[0];
        for (int i = 1; i < token.length; ++i) {
            String[] t = token[i].split("\\(");
            String content = t[1].substring(0, t[1].length()-1);
            List<FileInfo> l = content2File.getOrDefault(content, new ArrayList<>());
            l.add(new FileInfo(p, t[0]));
            content2File.put(content, l);
        }
    }
    
    private class FileInfo {
        String path;
        String fileName;
        
        FileInfo(String p, String n) {
            path = p;
            fileName = n;
        }
    }
}