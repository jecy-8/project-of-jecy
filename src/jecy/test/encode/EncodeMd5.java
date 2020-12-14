/*
package jecy.test.encode;


import org.apache.commons.codec.digest.DigestUtils;

import java.io.*;

public class EncodeMd5 {

    public static String md5(byte[] data) {
         return DigestUtils.md5Hex(data);
    }

    public static byte[] image2byte(String path){
        byte[] data = null;
        FileInputStream input = null;
        try {
            input = new FileInputStream(new File(path));
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            int numBytesRead = 0;
            while ((numBytesRead = input.read(buf)) != -1) {
                output.write(buf, 0, numBytesRead);
            }
            data = output.toByteArray();
            output.close();
            input.close();
        }
        catch (FileNotFoundException ex1) {
            ex1.printStackTrace();
        }
        catch (IOException ex1) {
            ex1.printStackTrace();
        }
        return data;
    }


    public static void main(String[] args) {
        String currentProjectPath = System.getProperty("user.dir");
        byte[] imageByte = image2byte(currentProjectPath + "/src/jecy/test/encode/002.jpg");
        System.out.println(md5(imageByte));
    }
}
*/
