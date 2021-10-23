package Others;

// 273
// How to initialize string array witn value - bracket init (like C++)
// Edge cases when num == 0
// whitespace trick -> s.strip()

public class NumberToWords {
    public String solutions(int num) {
//        2,147,483,648
//        Input: num = 1,234,567,891
//        Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
        String[] LT20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] TENS = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String[] UNITS = {"", "Thousand", "Million", "Billion"};

        String ret = "";
        int unitCntInThree = 0;

        if (num == 0) return "Zero";

        while (num > 0) {
            int remainder = num % 1000;
            num = (num - remainder) / 1000;
            if (remainder == 0) {
                unitCntInThree++;
                continue;
            }
            StringBuilder threeDigitEng = new StringBuilder();
            if (!LT20[remainder / 100].equals("")) threeDigitEng.append(LT20[remainder/100]).append(" Hundred ");
            remainder = remainder % 100;
            if (remainder / 10 == 1) {
                threeDigitEng.append(LT20[remainder]).append(" ");
            } else {
                if (!LT20[remainder / 10].equals("")) threeDigitEng.append(TENS[remainder/10]).append(" ");
                remainder = remainder % 10;
                if (!LT20[remainder].equals("")) threeDigitEng.append(LT20[remainder]).append(" ");
            }
            if (unitCntInThree > 0) threeDigitEng.append(UNITS[unitCntInThree]).append(" ");
            unitCntInThree++;
            ret = threeDigitEng.toString() + ret;
        }

        return ret.strip();
    }
}
