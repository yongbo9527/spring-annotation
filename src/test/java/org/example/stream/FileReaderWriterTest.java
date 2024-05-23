package org.example.stream;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.TreeSet;

/**
 * @Author: Ron
 * @Create: 2023-11-10 11:20
 */
public class FileReaderWriterTest {

    @Test
    public void test01() throws IOException {
        File file = new File("D:\\code\\hello.txt");
        if (file.exists()) {
            System.out.println("文件存在");
        } else {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        FileReader fr = null;
        try {
            fr = new FileReader(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        int data;
        while ((data = fr.read()) != -1) {
            System.out.print((char) data);
        }
        if (fr != null) {
            try {
                fr.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Test
    public void test02() {
        File file = new File("D:\\code\\hello2.txt");
        try (FileWriter fileWriter = new FileWriter(file, true)) {
            fileWriter.write("\n");
            fileWriter.write("you need to have a dream!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test02_1() {
        TreeSet<String> objects = new TreeSet<>();
        File file = new File("D:\\code\\hello2.txt");
        try (FileReader fileReader = new FileReader(file)) {
            BufferedReader br = new BufferedReader(fileReader);
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                objects.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(objects.size());
    }

    @Test
    public void test03() {
        File file = new File("D:\\code\\hello.txt");
        try (FileReader fr = new FileReader(file)) {
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test03_1() {
        File unlogin = new File("D:\\code\\hello2.txt");
        File login = new File("D:\\code\\hello.txt");
        ArrayList<String> unLoginList = new ArrayList<>();
        ArrayList<String> loginList = new ArrayList<>();


        try (FileReader fr = new FileReader(unlogin)) {
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                unLoginList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (FileReader fr2 = new FileReader(login)) {
            BufferedReader br = new BufferedReader(fr2);
            String line;
            while ((line = br.readLine()) != null) {
                loginList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList<String> strs = new ArrayList<>();
        File file = new File("D:\\code\\hello3.txt");
        try(FileWriter fw = new FileWriter(file, true)){
            for (String s : loginList) {
                if (!unLoginList.contains(s)) {
                    strs.add(s);
                    fw.write(s);
                    fw.write("\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(strs);
        System.out.println(strs.size());

    }

    @Test
    public void test04() {
        File file = new File("D:\\code\\hello.txt");
        try (FileReader fr = new FileReader(file)) {
            BufferedReader br = new BufferedReader(fr);
            while (br.ready()) {
                System.out.println(br.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test05() {
        File file = new File("D:\\code\\hello.txt");
        File file2 = new File("D:\\code\\hello2.txt");
        char[] cbuf = new char[500];
        int len;
        try (FileReader fr = new FileReader(file); FileWriter fw = new FileWriter(file2, true)) {
            while ((len = fr.read(cbuf)) != -1) {
                String str = new String(cbuf, 0, len);
                fw.write(str);
                System.out.print(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test06() {
        File file = new File("D:\\code\\周一.png");
        File file1 = new File("D:\\code\\周一1.png");
        try (FileInputStream fis = new FileInputStream(file); FileOutputStream fos = new FileOutputStream(file1)) {
//            char[] cbuf = new char[500];
            byte[] bbuf = new byte[1024];
            int len;
            while ((len = fis.read(bbuf)) != -1) {
                fos.write(bbuf, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test07() throws IOException {
        File file = new File("D:\\code\\hello.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        InputStreamReader is = new InputStreamReader(fileInputStream, "UTF-8");
        int data;
        while ((data = is.read()) != -1) {
            System.out.print((char) data);
        }
    }

    @Test
    public void test08() throws IOException {
        File file = new File("D:\\code\\周一.png");
        File file2 = new File("D:\\code\\周一2.png");
        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedInputStream bis = new BufferedInputStream(fileInputStream);
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file2));
        byte[] bbuf = new byte[1024];
        int len;
        while ((len = bis.read(bbuf)) != -1) {
            bos.write(bbuf, 0, len);
        }
    }

    @Test
    public void test09() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(new String("hello world!"));
        byte[] bytes = bos.toByteArray();
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = new ObjectInputStream(bis);
        String str = (String) ois.readObject();
        System.out.println(str);
    }


    @Test
    public void test10() throws Exception {
        RandomAccessFile raf1 = new RandomAccessFile("D:\\code\\hello.txt", "r");
        RandomAccessFile raf2 = new RandomAccessFile("D:\\code\\hello2.txt", "rw");

        byte[] cbuf = new byte[1024];
        int len;
        while ((len = raf1.read(cbuf)) != -1) {
            raf2.write(new String(cbuf, 0, len).getBytes());
//            raf2.write(cbuf,0,len);
        }

    }

    @Test
    public void test11() throws Exception {
        RandomAccessFile raf1 = new RandomAccessFile("D:\\code\\hello.txt", "rw");

        raf1.seek(3);//将指针调到角标为3的位置
        //保存指针3后面的所有数据到StringBuilder中
        StringBuilder builder = new StringBuilder((int) new File("D:\\code\\hello.txt").length());
        byte[] buffer = new byte[20];
        int len;
        while ((len = raf1.read(buffer)) != -1) {
            builder.append(new String(buffer, 0, len));
        }
        //调回指针，写入“xyz”
        raf1.seek(3);
        raf1.write("xyz".getBytes());

        //将StringBuilder中的数据写入到文件中
        raf1.write(builder.toString().getBytes());

        raf1.close();

    }

}
