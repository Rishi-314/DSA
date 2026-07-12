import java.util.Stack;
class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < operations.length; i++){
            String s = operations[i];
            if(s.equals("C")){
                stack.pop();
            }else if(s.equals("D")){
                stack.push(stack.peek() * 2);
            }else if(s.equals("+")){
                int a = stack.pop();
                int b = stack.peek();
                stack.push(a);
                stack.push(a + b);
            }else{
                stack.push(Integer.parseInt(s));
            }
        }
        int sum = 0;
        while (stack.size() != 0){
            sum += stack.pop();
        }
        return sum;
    }
}