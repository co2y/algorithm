package hihocoder9;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by co2y on 12/03/2017.
 */
public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String date1 = scanner.nextLine();
        String date2 = scanner.nextLine();
        if (date1.equals(date2)) {
            System.out.println(0);
            return;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d1 = null;
        Date d2 = null;
        String[] ss = {"1972-06-30 23:59:60", "1972-12-31 23:59:60", "1973-12-31 23:59:60", "1974-12-31 23:59:60",
                "1975-12-31 23:59:60", "1976-12-31 23:59:60", "1977-12-31 23:59:60", "1978-12-31 23:59:60", "1979-12-31 23:59:60",
                "1981-06-30 23:59:60", "1982-06-30 23:59:60", "1983-06-30 23:59:60", "1985-06-30 23:59:60", "1987-12-31 23:59:60",
                "1989-12-31 23:59:60", "1990-12-31 23:59:60", "1992-06-30 23:59:60", "1993-06-30 23:59:60", "1994-06-30 23:59:60",
                "1995-12-31 23:59:60", "1997-06-30 23:59:60", "1998-12-31 23:59:60", "2005-12-31 23:59:60", "2008-12-31 23:59:60",
                "2012-06-30 23:59:60", "2015-06-30 23:59:60", "2016-12-31 23:59:60"};
        try {
            d1 = sdf.parse(date1);
            d2 = sdf.parse(date2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int ans1 = (int) (d2.getTime() - d1.getTime()) / 1000;

        int idx1 = 0;
        int idx2 = 0;
        for (String s : ss) {
            try {
                Date d3 = sdf.parse(s);
                if (d1.compareTo(d3) > 0 || (d1.compareTo(d3)==0 && !date1.equals(s))) {
                    idx1++;
                    idx2++;
                    continue;
                }
                if (d2.compareTo(d3) >= 0) {
                    if (date2.equals(s)) {
                        break;
                    }
                    else
                        idx2++;
                } else {
                    break;
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        System.out.println(ans1 + idx2 - idx1);
    }
}
