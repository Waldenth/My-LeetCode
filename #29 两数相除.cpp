// 快速乘
inline auto quickAdd = [](int y, int z, int x) {
    // x 和 y 是负数，z 是正数
    // 需要判断 z * y >= x 是否成立
    // y+y+...y>=x
    int result = 0, add = y;
    while (z) {
        // z二进制最低位是1
        if (z & 1) {
            // 需要保证 result + add >= x
            if (result < x - add) {
                return false;
            }
            result += add;
        }
        if (z != 1) {
            // 需要保证 add + add >= x
            if (add < x - add) {
                return false;
            }
            add += add;
        }
        // 不能使用除法
        z >>= 1;
    }
    return true;
};

class Solution {
   public:
    //只能存储32位Int,int最小值-2^31无对应正数
    int divide(int dividend, int divisor) {
        //被除数为最小值
        if (dividend == INT_MIN) {
            if (divisor == 1)
                return INT_MIN;
            if (divisor == -1)
                return INT_MAX;  // overflow
        }

        // divisor is -2^31
        if (divisor == INT_MIN) {
            if (dividend == INT_MIN)
                return 1;
            else
                return 0;
        }

        // common situation , binary search
        // 将所有的正数取相反数，这样就只需要考虑一种情况
        bool rev = false;
        if (dividend > 0) {
            dividend = -dividend;
            rev = !rev;
        }
        if (divisor > 0) {
            divisor = -divisor;
            rev = !rev;
        }

        int left = 1, right = INT_MAX, ans = 0;
        while (left <= right) {
            // 注意溢出，并且不能使用除法
            int mid = left + ((right - left) >> 1);
            //除数,mid,被除数
            bool check = quickAdd(divisor, mid, dividend);
            //除数*mid>=被除数 , 注意除数被除数都是负数
            //说明|除数*mid|<=|被除数|
            //说明mid还不够大
            if (check) {
                ans = mid;
                // 注意溢出
                if (mid == INT_MAX) {
                    break;
                }
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return rev ? -ans : ans;
    }
};
