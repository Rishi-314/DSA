import java.util.ArrayList;

class Solution2 {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;
        while(low < high + 1){
            int n = low;
            int length = 0;
            ArrayList <Integer> list = new ArrayList<>();
            while (n > 0){
                list.add(n % 10);
                length++;
                n = n / 10;
            }
            low++;
            if(length % 2 != 0){
                continue;
            }
            int firstSum = 0;
            int secondSum = 0;
            int left = 0; 
            int right = length;
            while(right > left){
                firstSum +=  list.get(left);
                secondSum += list.get(right);
                left++;
                right--;
            }
            if(firstSum != secondSum){
                continue;
            }
            count++;
        }
        return count;
    }
}