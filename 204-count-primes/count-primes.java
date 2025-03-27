import java.util.Arrays;

public class Solution {
    public int countPrimes(int n) {
        if (n <= 2) return 0;
        
        boolean[] isPrime = new boolean[n];        
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!isPrime[i]) {
                count++;
                for (long j = (long) i * i; j < n; j += i) {
                    isPrime[(int) j] = true;
                }
            }
        }
        return count;
    }
}