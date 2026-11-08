class Solution {
    public int countPrimes(int n) {
        if(n < 3) return 0;
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for(int p = 2; (long) p * p < n; p++){
            if(isPrime[p]){
                for(int m = p*p; m < n; m += p){
                    isPrime[m] = false;
                }
            }
        }

        int res = 0;
        for(int i = 0; i < n; i++){
            if(isPrime[i]) res++;
        }
        return res;
    }
}