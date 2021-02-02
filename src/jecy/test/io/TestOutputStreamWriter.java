package jecy.test.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class TestOutputStreamWriter {
    public static void main(String[] args) {
        File f = new File("testReaderWriter.txt");
        try {
            OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(f), "UTF-8");
            osw.write("我是字符流转换成字节流输出的");
            osw.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }
}
