package Arrays.disappearednumber;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        int duplicate = 0;
        for(int i = 0; i < nums.length; i++){
            if(!set.contains(nums[i])){
                set.add(nums[i]);
            }else{
                duplicate++;
            }
        }
        int i = 1;
        while(duplicate != 0 & i < nums.length + 1){
                if(!set.contains(i)){
                    list.add(i);
                    duplicate--;
                }
                i++;
        }
        return list;
        
    }
}
