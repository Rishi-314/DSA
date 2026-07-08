
import java.util.HashMap;
import java.util.ArrayList;

class Solution {
    public int maxDigitRange(int[] nums) {
        int biggestDifference = 0;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int biggest = 0;
            int smallest = 10;
            int num = nums[i];
            while(num > 0){
                int rem = num % 10;
                System.out.println(rem);
                if(rem < smallest){
                    smallest = rem;
                    // System.out.println(smallest); 
                }
                if(rem > biggest){
                    biggest = rem;
                    // System.out.println(rem);
                }
                num = num / 10;
            }
            int difference = biggest - smallest;
            // System.out.println(difference);
            if(difference > biggestDifference){
                biggestDifference = difference;
            }
            if(!map.containsKey(difference)){
                map.put(difference,new ArrayList<>());
            }
            map.get(difference).add(nums[i]);
            System.out.println("---------");
        }

        ArrayList<Integer> list = map.get(biggestDifference);
        // System.out.println(list);
        int sum = 0;
        for(int k = 0; k < list.size(); k++){
            sum = list.get(k) + sum;
        }
        return sum;   
    }
}