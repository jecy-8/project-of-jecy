package jecy.test.io;

import java.io.*;

public class TestBIO {

    public static void main(String[] args) {
        User user = new User();
        user.setName("Jecy");
        user.setAge(18);

        // Write to file
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(new File("tmpBioFile")));
            oos.writeObject(user);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                oos.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }


        // Read from file
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("tmpBioFile"));
            User user1 = (User) ois.readObject();
            System.out.println("name=" + user1.name + ", age=" + user1.age);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                ois.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }





}
