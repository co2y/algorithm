package huawei;

import java.util.Scanner;

/**
 * Created by co2y on 24/03/2017.
 */
public class B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String op = scanner.next();
        int[] state = {1, 2, 3, 4, 5, 6};
        for (char ch : op.toCharArray()) {
            if (ch == 'L') {
                int temp = state[5];
                state[5] = state[0];
                state[0] = state[4];
                state[4] = state[1];
                state[1] = temp;
            } else if (ch == 'R') {
                int temp = state[5];
                state[5] = state[1];
                state[1] = state[4];
                state[4] = state[0];
                state[0] = temp;
            } else if (ch == 'F') {
                int temp = state[2];
                state[2] = state[4];
                state[4] = state[3];
                state[3] = state[5];
                state[5] = temp;
            } else if (ch == 'B') {
                int temp = state[4];
                state[4] = state[2];
                state[2] = state[5];
                state[5] = state[3];
                state[3] = temp;
            } else if (ch == 'A') {
                int temp = state[0];
                state[0] = state[3];
                state[3] = state[1];
                state[1] = state[2];
                state[2] = temp;
            } else if (ch == 'C') {
                int temp = state[0];
                state[0] = state[2];
                state[2] = state[1];
                state[1] = state[3];
                state[3] = temp;
            }
        }

        for (int st : state) System.out.print(st);
    }

}
