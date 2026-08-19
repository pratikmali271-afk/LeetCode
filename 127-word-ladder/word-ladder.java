class Pair {
    String first;
    int second;
    Pair(String first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(beginWord, 1));

        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) {
            return 0;
        }
        dict.remove(beginWord);

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            String word = curr.first;
            int step = curr.second;

            if (word.equals(endWord)) {
                return step;
            }

            for (int i = 0; i < word.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char[] chars = word.toCharArray();
                    chars[i] = ch;
                    String replaceWord = new String(chars);

                    if (dict.contains(replaceWord)) {
                        q.offer(new Pair(replaceWord, step + 1));
                        dict.remove(replaceWord);
                    }
                }
            }
        }
        return 0;
    }
}