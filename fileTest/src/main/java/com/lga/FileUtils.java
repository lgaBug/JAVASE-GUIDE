package com.lga;

import java.io.*;

/**
 *describe: 文件操作工具
 *
 *@author lga
 *@date  2019/10/22 0022 23:51
 */
public class FileUtils {

    /**
     * 删除文件夹下的所有文件
     * @param file
     * @return
     */
    public static boolean deleteAllFiles(File file){
        try {
            if (file.isFile()){//file是一个文件
                file.delete();
            }else{//file 是一个文件夹
                deleteFiles(file);
            }
        }catch (Exception e){
            return false;
        }
        return true;
    }

    //删除文件夹下的所有文件
    private static void deleteFiles(File file) {
        if (file.listFiles().length == 0){//空文件夹
            return ;
        }else{
            for (File fileTemp :file.listFiles()){
                if (fileTemp.isFile()){
                    fileTemp.delete();
                }else{
                    deleteFiles(fileTemp);
                }
            }
        }

    }

    /**
     * 重命名文件或者文件夹
     * @param filePath 文件路径
     * @param oldName 当前要重命名的文件或者文件夹名称
     * @param newName 需要重命名为该名称
     * @return
     */
    public static boolean renameFile(String filePath ,String oldName,String newName){
        File oldFile = new File(filePath+'/'+oldName);
        File newFile = new File(filePath+'/'+newName);
        if (!oldFile.exists()){ //文件不存在
            return false;
        }
        return oldFile.renameTo(newFile);
    }

    /**
     * 批量创建文件/件夹
     * @param filesPath 文件/文件夹路径
     * @return 返回创建的成功个数
     */
    public static int createFiles(String[] filesPath){
        int successCount = 0;
        try {
            if (filesPath.length > 0){
                for (String filePath : filesPath){
                    File newFile = new File(filePath);
                    boolean flag = false;
                    if (!newFile.exists()){//该文件不存在则创建
                        if (filePath.contains(".")){
                            if (!newFile.getParentFile().exists()){//先判断其父文件是否存在
                                newFile.getParentFile().mkdirs();
                            }
                             flag = newFile.createNewFile();
                        }else{
                             flag = newFile.mkdirs();
                        }
                        if (flag){
                            successCount++;
                        }
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return  successCount;
    }

    /**
     * 获取文本的内容
     * @param filePath 文本的路径
     * @return 返回文本内容字符串
     */
    public static String getFileContent(String filePath){
        String content = "";
        String lineText = "";
        File file = new File(filePath);
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            if (file.exists() && file.isFile()){
                isr = new InputStreamReader(new FileInputStream(file),"utf-8");
                br = new BufferedReader(isr);
                while ((lineText = br.readLine())!=null){
                    content +=lineText+'\n';
                }
                System.out.println("读取文件成功。。。。");
                System.out.println("读取的内容为:"+content);
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("读取文件失败。。。。");
        }finally {
            try {
                isr.close();
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return content;
    }
}
