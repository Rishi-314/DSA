package Arrays.twoSum;

import java.util.HashMap;
import java.util.Map;

/* 
This solution is more optimized than the 1st 
we use hashmaps 
Time Complexity - O(n)
Space Complexity - O(n)
*/


public class Solution2 {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();        
        for(int i =0; i < nums.length; i++){
            int complement = target - nums[i];
            if(map.containsKey(complement)){
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[] {};
    }

}