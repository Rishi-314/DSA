package Arrays.palindrome;

class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(x));
        StringBuilder sc = new StringBuilder(String.valueOf(x));
        sc.reverse();
        System.out.println(sc);
        for(int i = 0; i < sb.length(); i++){
            if(sb.charAt(i) != sc.charAt(i)){
                return false;
            }
        }
        return true;
    }
}