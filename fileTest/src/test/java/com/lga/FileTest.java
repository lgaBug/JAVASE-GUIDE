package com.lga;

import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileTest {


    @Test
    public void test1(){

        boolean flag = FileUtils.deleteAllFiles(new File("E:\\filetest"));
        System.out.println("flag = " + flag);
    }


    @Test
    public void test2(){
        FileUtils.renameFile("E:\\filetest\\2","1.txt","wl.txt");
    }

    @Test
    public void test3(){
        List<String> filesPath = new ArrayList<String>();
        filesPath.add("E:\\lgaTestFile\\1\\2\\3");
        filesPath.add("E:\\lgaTestFile\\temp2\\2.txt");
        filesPath.add("E:\\lgaTestFile\\temp3\\3.txt");
        System.out.println(FileUtils.createFiles(filesPath.toArray(new String[filesPath.size()])));
    }

    @Test
    public void test4(){

        String fileContent = FileUtils.getFileContent("E:\\lgaTestFile\\temp2\\2.txt");
    }
}
