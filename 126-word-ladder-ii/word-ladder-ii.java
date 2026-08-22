class Solution {
    List<List<String>> ans = new ArrayList<>();
    String b;
    HashMap<String, Integer> map = new HashMap<>();
    public void dfs(String word, List<String> seq){
        if(word.equals(b)){
            List<String> dup = new ArrayList<>(seq);
            Collections.reverse(dup);
            ans.add(dup);
            return;
        }

        int steps = map.get(word);
        for(int i = 0; i < word.length(); i++){
            for(char ch = 'a'; ch <= 'z'; ch++){
                char[] chars = word.toCharArray();
                chars[i] = ch;
                String replaceWord = new String(chars);

                if(map.containsKey(replaceWord) && map.get(replaceWord) + 1 == steps){
                    seq.add(replaceWord);
                    dfs(replaceWord, seq);
                    seq.remove(seq.size() - 1);
                }
            }
        }
    }
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet(wordList);

        if(!dict.contains(endWord)) return ans;

        Queue<String> q = new LinkedList<>();
        b = beginWord;
        q.offer(b);
        dict.remove(b);
        map.put(b, 0);

        while(!q.isEmpty()){
            String word = q.poll();
            int steps = map.get(word);

            if(word.equals(endWord)) break;

            for(int i = 0; i < beginWord.length(); i++){
                for(char ch = 'a'; ch <= 'z'; ch++){
                    char[] chars = word.toCharArray();
                    chars[i] = ch;
                    String replaceWord = new String(chars);

                    if(dict.contains(replaceWord)){
                        q.offer(replaceWord);
                        map.put(replaceWord, steps + 1);
                        dict.remove(replaceWord);
                    }
                }
            }
        }

        if (!map.containsKey(endWord)) return ans;
        
        List<String> seq = new ArrayList<>();
        seq.add(endWord);
        dfs(endWord, seq);

        return ans;
    }
}