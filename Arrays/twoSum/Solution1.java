package Arrays.twoSum;

/*
here we solve the solution of twoSum 
with the help of 2 for loops 
Time Complexity - O(n^2)
Space Complexity - O(1)
*/ 
  
        

public class Solution1{
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length - 1; i++){
            for(int j = 0; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    int[] arr = {i,j};
                    return arr;
                }
            }
        }
        return null;
    }
}
