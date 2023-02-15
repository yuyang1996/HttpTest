package org.example;

import java.io.*;

/**
 * @author gurong
 * @date 2023/2/14
 */
public class CopyFile {

    public static void main(String[] args) throws IOException {
        File file = new File("D:\\icon.png");
        FileInputStream fileInputStream = new FileInputStream(file);
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\ICU.png");
        byte[] bytes = new byte[1024 * 64];
        int len = -1;
        while ((len = fileInputStream.read(bytes)) != -1) {
            fileOutputStream.write(bytes, 0, len);
        }
        fileOutputStream.close();
        fileInputStream.close();
    }
}
