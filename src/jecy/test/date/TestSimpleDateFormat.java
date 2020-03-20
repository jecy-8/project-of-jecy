package jecy.test.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestSimpleDateFormat {

    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = sdf.format(date);
        System.out.println(dateStr);
        System.out.println(sdf.parse(dateStr));

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf2 = new SimpleDateFormat("YYYY");
        System.out.println(sdf2.format(sdf1.parse("2019-12-01")));
        System.out.println(sdf2.format(sdf1.parse("2019-12-30")));
        System.out.println(sdf2.format(sdf1.parse("2020-01-01")));

    }

}
