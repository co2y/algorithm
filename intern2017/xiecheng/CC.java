package xiecheng;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

/**
 * Created by co2y on 11/04/2017.
 */
public class CC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String lineone = scanner.nextLine();
        String[] count = lineone.split("\\]");
        int linenum = count.length;
        int xnum = Math.max(count[0].split(",").length, 1);
        BigDecimal[][] matrix = new BigDecimal[linenum][xnum + 1];
        lineone = lineone.replace("[", "");
        lineone = lineone.replace("]", "");
        int i = 0;
        int j = 0;
        for (String s : lineone.split(",")) {
            matrix[i][j] = BigDecimal.valueOf(Integer.valueOf(s.replaceAll("\\s*", "")));
            j++;
            if (j == xnum) {
                j = 0;
                i++;
            }
        }
        String linetwo = scanner.nextLine();
        linetwo = linetwo.replace("[", "");
        linetwo = linetwo.replace("]", "");
        int k = 0;
        for (String s : linetwo.split(",")) {
            matrix[k][xnum] = BigDecimal.valueOf(Integer.valueOf(s.replaceAll("\\s*", "")));
            k++;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        BigDecimal[] rst = solveEquation(matrix, xnum + 1, RoundingMode.HALF_UP);
        for (BigDecimal aRst : rst) {
            if (String.valueOf(aRst.doubleValue()).split("\\.")[1].length() <= 5)
                sb.append(aRst.doubleValue());
            else
                sb.append(String.format("%.5f", aRst.doubleValue()));
            sb.append(", ");
        }
        String ans = sb.toString().substring(0, sb.toString().length() - 2);
        System.out.println(ans + "]");

    }


    public static BigDecimal[] solveEquation(BigDecimal[][] matrix, int scale, RoundingMode roundingMode) {
        if (isNullOrEmptyMatrix(matrix)) {
            return new BigDecimal[0];
        }
        BigDecimal[][] triangular = elimination(matrix, scale, roundingMode);
        return substitutionUpMethod(triangular, scale, roundingMode);
    }

    private static BigDecimal[][] elimination(BigDecimal[][] matrix, int scale, RoundingMode roundingMode) {
        if (isNullOrEmptyMatrix(matrix) || matrix.length != matrix[0].length - 1) {
            return new BigDecimal[0][0];
        }
        int matrixLine = matrix.length;
        for (int i = 0; i < matrixLine - 1; ++i) {
            for (int j = i + 1; j < matrixLine; ++j) {
                for (int k = i + 1; k <= matrixLine; ++k) {
                    matrix[j][k] = matrix[j][k].subtract((matrix[i][k].divide(matrix[i][i], scale, roundingMode).multiply(matrix[j][i])));
                }
                matrix[j][i] = BigDecimal.ZERO;
            }
        }
        return matrix;
    }

    private static BigDecimal[] substitutionUpMethod(BigDecimal[][] matrix, int scale, RoundingMode roundingMode) {
        int row = matrix.length;
        BigDecimal[] result = new BigDecimal[row];
        for (int i = 0; i < result.length; ++i) {
            result[i] = BigDecimal.ONE;
        }
        BigDecimal tmp;
        for (int i = row - 1; i >= 0; --i) {
            tmp = BigDecimal.ZERO;
            int j = row - 1;
            while (j > i) {
                tmp = tmp.add(matrix[i][j].multiply(result[j]));
                --j;
            }
            result[i] = matrix[i][row].subtract(tmp).divide(matrix[i][i], scale, roundingMode);
        }
        return result;
    }

    private static boolean isNullOrEmptyMatrix(BigDecimal[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return true;
        }
        int col = matrix[0].length;
        for (BigDecimal[] aMatrix : matrix) {
            for (int j = 0; j < col; ++j) {
                if (aMatrix[j] == null) {
                    return true;
                }
            }
        }
        return false;
    }
}