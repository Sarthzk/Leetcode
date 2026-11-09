class Solution {
    public double myPow(double x, int n) {
        long N = n;
        double res = power(x, Math.abs(N));
        return n < 0 ? 1 / res : res;
    }

    double power(double x, long n){
        if(n == 0) return 1;
        double half = power(x, n/2);
        if(n%2 == 0) return half * half;
        else return half * half * x;
    }
}