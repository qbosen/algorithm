package top.abosen.leetcode;

//[273] 整数转换英文表示
/* 123 */
public class IntegerToEnglishWords {
    public static void main(String[] args) {
        Solution solution = new IntegerToEnglishWords().new Solution();
        System.out.println(solution.numberToWords(1));
        System.out.println(solution.numberToWords(10));
        System.out.println(solution.numberToWords(100));
        System.out.println(solution.numberToWords(123));
        System.out.println(solution.numberToWords(12345));
        System.out.println(solution.numberToWords(1234567));
        System.out.println(solution.numberToWords(1234567890));
        System.out.println(solution.numberToWords(1234567891));
        System.out.println(solution.numberToWords(1000100000));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        String[] singles = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        String[] teens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String[] thousands = {"", "Thousand", "Million", "Billion"};


        public String numberToWords(int num) {
            if (num == 0) {
                return "Zero";
            }
            StringBuilder res = new StringBuilder();
            StringBuilder sb = new StringBuilder();
            for (int i = thousands.length - 1, unit = 1000_000_000; i >= 0; i--, unit /= 1000) {
                int cur = num / unit;
                if (cur != 0) {
                    num = num - cur * unit;
                    toEnglish(cur, sb);
                    if (res.length() > 0) {
                        res.append(' ');
                    }
                    res.append(sb);
                    if (i > 0) {
                        res.append(' ').append(thousands[i]);
                    }
                }
            }
            return res.toString();
        }

        private void toEnglish(int cur, StringBuilder sb) {
            sb.setLength(0);

            int hundred = cur / 100;
            if (hundred != 0) {
                cur -= hundred * 100;
                sb.append(singles[hundred]).append(' ').append("Hundred");
            }
            int ten = cur / 10;
            cur -= ten * 10;
            if (ten > 1) {
                if (sb.length() > 0) {
                    sb.append(' ');
                }
                sb.append(tens[ten]);
            }


            if (ten == 1) {
                if (sb.length() > 0) {
                    sb.append(' ');
                }   sb.append(teens[cur]);
            } else {
                if (sb.length() > 0 && cur > 0) {
                    sb.append(' ');
                }
                sb.append(singles[cur]);
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}