package hihocoder11;

import java.util.Scanner;

/**
 * Created by co2y on 26/03/2017.
 */
public class AA {
    static int m;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.next();
        char[] chs = line.toCharArray();
        m = chs.length + 1;
        int ans = m;
        int firsth = m, secondh = m, firsti = m, firsto = m;

        for (int i = 0; i < chs.length; ++i) {
            if (chs[i] == 'h') {
                if (firsth == m) firsth = i;
                else if (secondh == m) secondh = i;
                else {
                    if (firsti < firsth) firsti = m;
                    if (firsto < firsth) firsto = m;
                    firsth = secondh;
                    secondh = i;
                }

            } else if (chs[i] == 'o') {
                if (firsto == m) firsto = i;
                else {
                    if (firsti < firsto) firsti = m;
                    if (firsth < firsto) firsth = m;
                    if (secondh < firsto) secondh = m;
                    firsto = i;
                }

            } else if (chs[i] == 'i') {
                if (firsti == m) firsti = i;
                else {
                    if (firsto < firsti) firsto = m;
                    if (firsth < firsti) firsth = m;
                    if (secondh < firsti) secondh = m;
                    firsti = i;
                }
            }

            ans = Math.min(ans, getAns(firsth, secondh, firsti, firsto));
        }


        if (ans > chs.length) System.out.println(-1);
        else System.out.println(ans + 1);
    }

    private static int getAns(int firsth, int secondh, int firsti, int firsto) {
        if (firsth == m || secondh == m || firsti == m || firsto == m) return m;
        int temp1 = Math.min(Math.min(firsth, secondh), Math.min(firsti, firsto));
        int temp2 = Math.max(Math.max(firsth, secondh), Math.max(firsti, firsto));
        return temp2 - temp1;
    }
}
