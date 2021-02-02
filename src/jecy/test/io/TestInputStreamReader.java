package jecy.test.io;

import java.io.*;

public class TestInputStreamReader {
    public static void main(String[] args) {
        File f = new File("testReaderWriter.txt");
        try {
            InputStreamReader isr = new InputStreamReader(new FileInputStream(f), "UTF-8");
            char[] buf = new char[1024];
            int len = isr.read(buf);
            System.out.println(new String(buf, 0, len));
            isr.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
