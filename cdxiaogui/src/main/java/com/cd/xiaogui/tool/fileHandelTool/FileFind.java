package com.cd.xiaogui.tool.fileHandelTool;

import java.io.*;
import java.util.*;

public class FileFind {

    static List ignore = new ArrayList(){{
        add("target");
        add(".xml");
        add(".iml");

    }};
    public static void main(String[] args) throws IOException {
//        readfile("/Users/sunyawei3/Desktop/syw/workspace/wj-order/wj-order-structure-client-api");
//        folderMethod2("/Users/sunyawei3/Desktop/syw/workspace/wj-order/wj-order-structure-client-api");

        folderMethod2("/Users/sunyawei3/Desktop/syw/workspace/wj-order/wj-order-structure-client-api");

        folderMethod2("/Users/sunyawei3/Desktop/syw/workspace/wj-order/wj-order-structure-domain");
        System.out.println("wj-order-structure-common");
//        folderMethod2("/Users/sunyawei3/Desktop/syw/workspace/wj-order/wj-order-structure-common");
//        folderMethod2("/Users/sunyawei3/Desktop/syw/workspace/wj-order");
    }

    public static void readfile(String path) {
        int fileNum = 0, folderNum = 0;
        File file = new File(path);
        LinkedList<File> list = new LinkedList<>();

        if (file.exists()) {
            if (null == file.listFiles()) {
                return;
            }
            list.addAll(Arrays.asList(file.listFiles()));
            while (!list.isEmpty()) {
                File[] files = list.removeFirst().listFiles();
                if (null == files) {
                    continue;
                }
                for (File f : files) {
                    if (f.isDirectory()) {
                        System.out.println("文件夹:" + f.getAbsolutePath() + "===="+f.getName());
                        list.add(f);
                        folderNum++;
                    } else {
                        System.out.println("文件:" + f.getAbsolutePath());
                        fileNum++;
                    }
                }
            }
        } else {
            System.out.println("文件不存在!");
        }
        System.out.println("文件夹数量:" + folderNum + ",文件数量:" + fileNum);
    }
    static String base_path ="\t";
    public static void folderMethod2(String path) {
        File file = new File(path);
        if (file.exists()) {
            File[] files = file.listFiles();
            if (null != files) {
                for (File file2 : files) {
                    if (file2.isDirectory()) {
                        if(ignore.contains(file2.getName())
//                                || file2.getName().contains("enum")
                        ) continue;
                        folderMethod2(file2.getAbsolutePath());
                    } else {

                        if(!file2.getName().contains(".java") ||
//                                file2.getName().toLowerCase(Locale.ROOT).contains("enum")||
                                file2.getName().toLowerCase(Locale.ROOT).contains("aspect") ||
                                file2.getName().toLowerCase(Locale.ROOT).contains("util")||
                                file2.getName().toLowerCase(Locale.ROOT).contains("exception")
                        ) continue;


                            if(readTxt(file2.getAbsolutePath())){
//                                System.out.println(" 存在");
                            }else {
                                System.out.print("文件:" + file2.getAbsolutePath());
                                System.out.println(" 不存在");
                            }
//                        break;
                    }
                }
            }
        } else {
            System.out.println("文件不存在!");
        }
    }

    static boolean readTxt(String path)  {
        InputStreamReader readStream= null;
        boolean flag = false;
        BufferedReader reader = null;
        try {
            FileInputStream filestream=new FileInputStream(path);
            byte[] b = new byte[3];
            filestream.read(b);
            String ecode="gbk";
            if (b[0] == -17 && b[1] == -69 && b[2] == -65){
                ecode="utf-8";
            }

            readStream = new InputStreamReader(filestream,ecode);

            reader=new BufferedReader(readStream);

            String temp=null;
            int line=0;//行号

            while((temp=reader.readLine())!=null){
                line++;
                if(temp.contains("Serializable") || temp.contains("interface")
//                        || temp.contains("public enum")
                ) {
                    flag =true;

                    break;
                }
//                System.out.println(line+":"+temp);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e3){
            try {
                readStream.close();
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }

}
