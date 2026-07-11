class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n];
        for(int i = 0; i < logs.size(); i++){
            String s = logs.get(i);
            int id = s.charAt(0) - '0';
            char pos = s.charAt(2);
            int value;
            if(pos == 's'){
                value = s.charAt(8) - '0';
            }else{
                value = s.charAt(6) - '0';
            }
            System.out.println("id " + id + " position " + pos + " value " + value);
            
            if(pos == 's'){
                stack.add(value);
                System.out.println("Pushed" + value);
            }else{
                int a = stack.pop();
                System.out.println("Pop" + a);
                if(id < n - 1){
                    ans[id] = value - a + 1 - ans[id + 1];
                }else{
                    ans[id] = value - a + 1;           
                }
                System.out.println(ans[id]);
            }

        }
        return ans;
    }    
}