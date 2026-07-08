package Arrays.palindrome;

class Solution2 {
    public boolean isPalindrome(int x) {
        int z = x;
        int rev = 0;
        while(x > 0){
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        if(z != rev){
            return false;
        }
        return true;
    }
}