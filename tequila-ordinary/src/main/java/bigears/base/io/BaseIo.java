package bigears.base.io;

import java.io.*;

/**
 * BaseIo
 *
 * @author shenyang
 */
public class BaseIo {

    @SuppressWarnings("unused")
    public static void testFileInputStream() {
        try {
            FileInputStream fileInputStream = new FileInputStream("D:\\search.log");
            int read;
            byte[] bytes = new byte[1024];
            while ((read = fileInputStream.read(bytes)) > 0) {
                System.out.println("read:" + read);
                System.out.println(new String(bytes, 0, read));
            }
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unused")
    public static void testStreamFileCopy() {
        try {
            FileInputStream fileInputStream = new FileInputStream("D:\\search.log");
            FileOutputStream fileOutputStream = new FileOutputStream("D:\\search_copy.log");
            int read;
            byte[] bytes = new byte[1024];
            while ((read = fileInputStream.read(bytes)) > 0) {
                fileOutputStream.write(bytes, 0, read);
            }
            fileInputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unused")
    public static void testCharFileReader() {
        try {
            FileReader fileReader = new FileReader("D:\\search.log");
            int read;
            char[] chars = new char[10];
            PrintWriter writer = new PrintWriter(System.out);
            while ((read = fileReader.read(chars)) > 0) {
                System.out.println("read:" + read);
                writer.write(chars, 0, read);
            }
            writer.flush();
            fileReader.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @SuppressWarnings("unused")
    public static void testBufferReader() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\search.log"));
            String temp;
            while ((temp = bufferedReader.readLine()) != null){
                System.out.println(temp);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unused")
    public static void testStandardInputOutput() {
        String s;
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        try {
            s = bufferedReader.readLine();
            while (s != null) {
                System.out.println(s);
                s = bufferedReader.readLine();
            }
            bufferedReader.close();
            inputStreamReader.close();
            System.out.println("end");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unused")
    public static void testOutputStreamWriter() {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(System.out);
            outputStreamWriter.write("test");
            outputStreamWriter.close();
            OutputStreamWriter outputStreamWriter1 = new OutputStreamWriter(new FileOutputStream(new File("D:\\search_2.log")));
            outputStreamWriter1.write("test");
            outputStreamWriter1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        BaseIo.testStreamFileCopy();
    }

}
