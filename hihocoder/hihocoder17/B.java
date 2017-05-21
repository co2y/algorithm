import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i=0; i<n; ++i) {
            nums[i] = scanner.nextInt();
        }

        int value=n;
        int temp=0;
        for (int i=n; i>=1; --i) {
			if (nums[i-1] == value) {
				value--;
				temp++;
			}
		}
		System.out.println(n-temp);

    }
}
