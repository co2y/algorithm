import java.text.DecimalFormat;
import java.util.Scanner;

public class Microsoft1 {

    static class TreeNode{
        public int depth;
        public int P;
        public double TotalP;
        public boolean newFound = false;
        public int lastP;
    }

    private static double Ex = 0.0;

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int P=scanner.nextInt(),Q = scanner.nextInt(),N = scanner.nextInt();
        scanner.close();
        TreeNode root = new TreeNode();
        root.P = 0;
        root.TotalP = 1;
        root.newFound = true;
        root.depth = 0;
        Ex = 0;
        Generate(root, N, 0, P, Q);
        System.out.println(new DecimalFormat("#.00").format(Ex));
    }

    private static void Generate(TreeNode parent, int N, int currentN, int P, int Q){
        if(N == currentN){
            Ex += parent.depth*parent.TotalP;
            return;
        }
        int leftP;
        if(parent.newFound){
            leftP = (int)(P/(Math.pow(2,currentN)));
        }
        else
            leftP = parent.lastP + Q;
        if(leftP > 100)
            leftP = 100;
        TreeNode left = new TreeNode(),right = new TreeNode();

        left.depth = parent.depth+1;
        left.P = leftP;
        left.newFound = true;
        left.TotalP = parent.TotalP*(leftP*1.0/100);
        Generate(left, N, currentN+1, P, Q);

        if(leftP<100){
            right.depth = parent.depth+1;
            right.P = 100-leftP;
            right.lastP = leftP;
            right.newFound = false;
            right.TotalP = parent.TotalP*(right.P*1.0/100);
            Generate(right, N, currentN, P, Q);
        }

    }
}
