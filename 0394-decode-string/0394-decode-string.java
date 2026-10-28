class Solution {
    public String decodeString(String s) {
        Deque<Integer> counts = new ArrayDeque<>();
        Deque<StringBuilder> texts = new ArrayDeque<>();
        StringBuilder curr = new StringBuilder();
        int k = 0;

        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                k = k * 10 + (c - '0');
            }
            else if (c == '['){
                counts.push(k);
                texts.push(curr);
                curr = new StringBuilder();
                k = 0;
            }
            else if(c == ']'){
                int times = counts.pop();
                StringBuilder saved = texts.pop();
                for(int i = 0; i < times; i++){
                    saved.append(curr);
                }
                curr = saved;
            }
            else {
                curr.append(c);
            }
        }
        return curr.toString();
    }
}