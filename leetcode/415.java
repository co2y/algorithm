public class Solution {
    public String addStrings(String num1, String num2) {

        if (num1.length() > num2.length()) {
            String temp = String.format("%0" + (num1.length()-num2.length()) + "d", 0);
            num2 = temp + num2;
        } else if (num1.length() < num2.length()) {
            String temp = String.join("", Collections.nCopies(num2.length()-num1.length(), "0"));;
            num1 = temp + num1;
        }

        int len;
        len = num1.length();

        char[] ch1 = num1.toCharArray();
        char[] ch2 = num2.toCharArray();
        int plus = 0;
        StringBuilder sb = new StringBuilder();
        for (int i=len-1; i>=0; --i) {
            int temp = plus + (ch1[i] - '0') + (ch2[i] - '0');
            if (temp >= 10) {
                plus = 1;
                temp -= 10;
            } else {
                plus = 0;
            }
            sb.append(temp);
        }

        if (plus == 1) {
            sb.append(plus);
        }

        return sb.reverse().toString();
    }
}
