class Solution {
    public String removeDuplicates(String s) {
        Deque<Character> stack = new ArrayDeque<>();


        for(int i = 0; i < s.length(); i++){
            Character c = s.charAt(i);

            if(c.equals(stack.peek())){
                stack.pop();
            }
            else{
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        String res = sb.reverse().toString();

        return res;
    }
}