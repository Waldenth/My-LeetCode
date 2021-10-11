class Solution {
   public:
    vector<string> singles = {"",     "One", "Two",   "Three", "Four",
                              "Five", "Six", "Seven", "Eight", "Nine"};
    vector<string> teens = {"Ten",     "Eleven",  "Twelve",    "Thirteen", "Fourteen",
                            "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    vector<string> tens = {"",      "Ten",   "Twenty",  "Thirty", "Forty",
                           "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    vector<string> thousands = {"", "Thousand", "Million", "Billion"};

    string numberToWords(int num) {
        if (num == 0)
            return "Zero";
        string sb;
        for (int i = 3, unit = 1000000000; i >= 0; i--, unit /= 1000) {
            int curNum = num / unit;
            if (curNum != 0) {
                num = num - curNum * unit;
                sb = sb + toEnglish(curNum) + thousands[i] + " ";
            }
        }

        while (sb.back() == ' ') {
            sb.pop_back();
        }
        return sb;
    };
    string toEnglish(int num) {
        string curr;
        int hundred = num / 100;
        num %= 100;
        if (hundred != 0) {
            curr = curr + singles[hundred] + " Hundred ";
        }

        int ten = num / 10;

        // 说明num>=20,小于20的英文可以直接表示one -nineteen
        if (ten >= 2) {
            curr = curr + tens[ten] + " ";
            num %= 10;
        }

        if (num > 0 && num < 10) {
            curr = curr + singles[num] + " ";
        } else if (num >= 10) {
            curr = curr + teens[num - 10] + " ";
        }
        return curr;
    }
};
