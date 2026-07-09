import java.util.ArrayList;

class Solution {
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
            int mid = length / 2;
            int firstSum = 0;
            for(int i = 0; i < mid; i++){
                firstSum += list.get(i);
            }
            int secondSum = 0;
            for(int i = mid; i < length; i++){
                secondSum += list.get(i);
            }
            if(firstSum != secondSum){
                continue;
            }
            count++;
        }
        return count;
    }
}