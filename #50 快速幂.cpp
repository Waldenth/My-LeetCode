class Solution {
   public:
    double quickMul(double x, long long N) {
        if (N == 0)
            return 1.0;
        double y = quickMul(x, N / 2);
        if (N % 2 == 0)
            return y * y;
        return y * y * x;
    }

    double myPow(double x, int n) {
        long long N = n;
        if (N >= 0)
            return quickMul(x, N);
        // n最小可取-2^31,取正2^31超出Int范围
        return 1.0 / quickMul(x, -N);
    }
};
