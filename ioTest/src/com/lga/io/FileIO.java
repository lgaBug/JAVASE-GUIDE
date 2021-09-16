package org.com.msb.io;

import java.io.File;
import java.io.FileInputStream;

/**
 * @author hj
 * @version 1.0
 * @description: TODO
 * @date 2021/6/26 20:52
 */
public class FileIO {
    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Users\\hj\\Desktop\\java\\hello.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        int read = fileInputStream.read();
        System.out.println((char) read);
    }
}
