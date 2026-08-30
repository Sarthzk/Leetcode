class Solution {
    public boolean backspaceCompare(String s, String t) {
        Deque<Character> stack_s = new ArrayDeque<>();
        Deque<Character> stack_t = new ArrayDeque<>();

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '#'){
                if(!stack_s.isEmpty()){
                    stack_s.pop();
                }
                continue;
            }
            stack_s.push(s.charAt(i));
        }

        for(int i = 0; i < t.length(); i++){
            if(t.charAt(i) == '#'){
                if(!stack_t.isEmpty()){
                    stack_t.pop();
                }
                continue;
            }
            stack_t.push(t.charAt(i));
        }
        if(stack_s.size() != stack_t.size()) return false;
        while(!stack_s.isEmpty()){
            if(stack_s.pop() != stack_t.pop()) return false;
        }
        return true;
    }
}