class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        if(nums.length == 1 && nums[0] == 1){
            int a = 1;
            return a;
        }
        if(nums.length == 1 && nums[0] == 0){
            int b = 0;
            return b;
        }
        int count = 0;
        int slow = 0;
        int fast = 1;
        int finalCount = 0;
        while(fast < nums.length){
            System.out.println("Loop");
            if(nums[slow] == nums[fast] && nums[fast] == 1){
                if(slow == 0){
                    count++;
                }
                fast++;
                count++;
                if(finalCount < count){
                    finalCount = count;
                }
            }else{
                slow = fast;
                fast++;
                System.out.println("count" + count);
                if(finalCount < count){
                    finalCount = count;
                }
                count = 1;
                System.out.println("finalcount" + finalCount);
            }
            System.out.println("finalcount outside" + finalCount);
            System.out.println(count);
        }
        System.out.println("finalcount outside" + finalCount);
        return finalCount;
    }
}