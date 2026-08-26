class Solution {
    public int calPoints(String[] operations) {
        Deque<Integer> stack = new ArrayDeque<>();
        int res = 0;

        for(String c : operations){
            if(c.equals("+")){
                int i = stack.pop();
                int j = i + stack.peek();
                stack.push(i);
                stack.push(j);
            }
            else if(c.equals("D")){
                stack.push(stack.peek() * 2);
            }
            else if(c.equals("C")){
                stack.pop();
            }
            else{
                stack.push(Integer.parseInt(c));
            }
        }
        while(!stack.isEmpty()){
            res = res + stack.pop();
        }
        return res;
    }
}