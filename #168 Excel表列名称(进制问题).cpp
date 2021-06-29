class Solution {
   public:
    string convertToTitle(int columnNumber) {
        string res;
        while (columnNumber > 0) {
            int n = (columnNumber - 1) % 26;
            res = res + (char)(n + 'A');
            columnNumber = (columnNumber - 1) / 26;
        }
        reverse(res.begin(), res.end());
        return res;
    }
};