package jecy.test.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class TestNIO {
    public static void main(String[] args) {
        //NIO写入
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("tmpNioFile");
            FileChannel fileWriteChannel = fos.getChannel();
            ByteBuffer byteWriteBuffer = Charset.forName("utf8").encode("Hello你好！");

            System.out.println("初始化容量和limit:" + byteWriteBuffer.capacity() + ", " + byteWriteBuffer.limit());
            int len = 0;
            while ((len = fileWriteChannel.write(byteWriteBuffer)) != 0) {
                // 这里不需要 clear， 将缓冲中的数据写入到通道中后 第二次接着上一次的顺序往下读
                System.out.println("写入长度：" + len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }

        // NIO读取
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("tmpNioFile");
            FileChannel fileReadChannel = fis.getChannel();

            // 100字节
            int capacity = 100;
            ByteBuffer byteReadBuffer = ByteBuffer.allocate(capacity);
            System.out.println("limit=" + byteReadBuffer.limit() + ", capacity=" + capacity
                    + ", location=" + byteReadBuffer.position());
            int length = -1;
            while ((length = fileReadChannel.read(byteReadBuffer)) != -1) {
                // 读取后，将位置置为0，将limit置为容量，以备下次读入到字节缓冲中从0开始存储
                byteReadBuffer.clear();
                byte[] bytes = byteReadBuffer.array();
                System.out.write(bytes, 0, length);
                System.out.println();

                System.out.println("limit=" + byteReadBuffer.limit() + ", capacity=" + capacity
                        + ", location=" + byteReadBuffer.position());
            }
            fileReadChannel.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }

    }
}
