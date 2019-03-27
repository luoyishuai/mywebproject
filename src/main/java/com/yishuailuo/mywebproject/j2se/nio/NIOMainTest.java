package com.yishuailuo.mywebproject.j2se.nio;

import org.apache.commons.codec.binary.Base64;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOMainTest {
    
    public static void main(String[] args) throws IOException {
        FileInputStream fin = new FileInputStream("/Users/luoyishuai/LatteBank/GitProjects/mywebproject/src/main/java/com/yishuailuo/mywebproject/j2se/nio/readandshow.txt");
        FileChannel fc = fin.getChannel();
        
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int bytesRead = fc.read(buffer);
        while (bytesRead != -1) {
            buffer.flip();
            while (buffer.hasRemaining()) {
                System.out.print((char) buffer.get());
            }
            buffer.clear();
            bytesRead = fc.read(buffer);
        }
        fc.close();
        fin.close();
    }
    
    
}
