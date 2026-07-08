import java.util.ArrayList;
// https://leetcode.com/problems/concatenate-non-zero-digits-and-multiply-by-sum-ii/description/?envType=daily-question&envId=2026-07-08

class Solution {

    private int firstGreaterOrEqual(ArrayList<Integer> positions, int target) {
        int left = 0;
        int right = positions.size() - 1;
        int ans = positions.size();

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (positions.get(mid) >= target) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    private int lastLessOrEqual(ArrayList<Integer> positions, int target) {
        int left = 0;
        int right = positions.size() - 1;
        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (positions.get(mid) <= target) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }

    public int[] sumAndMultiply(String s, int[][] queries) {

        final int MOD = 1_000_000_007;
        int q = queries.length;
        int[] ans = new int[q];

        ArrayList<Integer> positions = new ArrayList<>();
        ArrayList<Integer> digits = new ArrayList<>();

        // Build positions and digits
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch != '0') {
                positions.add(i);
                digits.add(ch - '0');
            }
        }

        if (digits.isEmpty()) {
            return ans;
        }

        // Prefix sum of non-zero digits
        int[] digitPrefix = new int[digits.size()];
        digitPrefix[0] = digits.get(0);

        for (int i = 1; i < digits.size(); i++) {
            digitPrefix[i] = digitPrefix[i - 1] + digits.get(i);
        }

        // Prefix concatenated number (mod MOD)
        long[] prefixNum = new long[digits.size()];
        prefixNum[0] = digits.get(0);

        for (int i = 1; i < digits.size(); i++) {
            prefixNum[i] = (prefixNum[i - 1] * 10 + digits.get(i)) % MOD;
        }

        // Powers of 10
        long[] pow10 = new long[digits.size() + 1];
        pow10[0] = 1;

        for (int i = 1; i <= digits.size(); i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }

        // Process queries
        for (int qi = 0; qi < q; qi++) {

            int L = queries[qi][0];
            int R = queries[qi][1];

            int startIdx = firstGreaterOrEqual(positions, L);
            int endIdx = lastLessOrEqual(positions, R);

            if (startIdx > endIdx || startIdx == positions.size()) {
                ans[qi] = 0;
                continue;
            }

            // Sum of digits
            long digitSum;
            if (startIdx == 0) {
                digitSum = digitPrefix[endIdx];
            } else {
                digitSum = digitPrefix[endIdx] - digitPrefix[startIdx - 1];
            }

            int len = endIdx - startIdx + 1;

            // Concatenated number modulo MOD
            long xMod;
            if (startIdx == 0) {
                xMod = prefixNum[endIdx];
            } else {
                xMod = (prefixNum[endIdx]
                        - (prefixNum[startIdx - 1] * pow10[len]) % MOD
                        + MOD) % MOD;
            }

            ans[qi] = (int) ((xMod * digitSum) % MOD);
        }

        return ans;
    }
}