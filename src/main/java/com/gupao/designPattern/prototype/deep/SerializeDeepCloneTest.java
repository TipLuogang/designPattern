package com.gupao.designPattern.prototype.deep;

import java.io.*;

public class SerializeDeepCloneTest {
    public static void main(String[] args) {
        SchoolSeri sch = new SchoolSeri("zjut",new StudentSeri("tyj"));
        SchoolSeri schSeri = null;
        System.out.println(sch);
        try {
            schSeri = SerializeDeepCloneUtil.deepClone(sch);
            System.out.println(sch);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(sch == schSeri);
        System.out.println(sch.getStu() == schSeri.getStu());
    }
}

class SerializeDeepCloneUtil{

    //序列化深克隆
    static <T extends Serializable> T deepClone(T obj){
        if(obj ==null){
            return null;
        }

        T cloneObj = null;

        //序列化
        ByteArrayOutputStream bout = null;
        ObjectOutputStream oos = null;
        try {
            //创建字节数组输出流
            //new ByteArrayOutputStream() Creates a new byte array output stream.
            bout = new ByteArrayOutputStream();
            //创建对象输出流
            //new ObjectOutputStream(OutputStream out): Creates an ObjectOutputStream that writes to the specified OutputStream.
            oos = new ObjectOutputStream(bout);
            //向对象输出流中写数据
            //void writeObject(Object obj): Write the specified object to the ObjectOutputStream.
            oos.writeObject(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            close(oos);
            close(bout);
        }

        //反序列化
        ByteArrayInputStream bin = null;
        ObjectInputStream ois = null;

        try {
            //创建字节数组输入流
            //new ByteArrayInputStream(byte buf[]): Creates a ByteArrayInputStream so that it  uses buf as its buffer array.
            bin = new ByteArrayInputStream(bout.toByteArray());
            //创建对象输入流
            //new  ObjectInputStream(InputStream in): Creates an ObjectInputStream that reads from the specified InputStream.
            ois = new ObjectInputStream(bin);
            //从对象输入流中读取数据
            //Object readObject(): Read an object from the ObjectInputStream.
            cloneObj = (T)ois.readObject();

        } catch (IOException  | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            close(ois);
            close(bin);
        }
        return cloneObj;
    }


    //关闭流
    private static void close(Closeable closeable){
        if(closeable != null){
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
