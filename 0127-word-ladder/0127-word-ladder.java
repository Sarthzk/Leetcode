class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        if(!words.contains(endWord)) return 0;

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int length = 1;

        while(!q.isEmpty()){
            int levelSize = q.size();

            for(int i = 0; i < levelSize; i++){
                String word = q.poll();
                if(word.equals(endWord)) return length;

                char[] chars = word.toCharArray();
                for(int pos = 0; pos < chars.length; pos++){
                    char og = chars[pos];
                    for(char c = 'a'; c <= 'z'; c++){
                        chars[pos] = c;
                        String next = new String(chars);
                        if(words.remove(next)){
                            q.offer(next);
                        }
                    }
                    chars[pos] = og;
                }
            }
            length++;
        }
        return 0;
    }
}