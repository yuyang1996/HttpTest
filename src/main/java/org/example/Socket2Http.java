package org.example;

import java.io.*;
import java.net.Socket;

/**
 * @author gurong
 * @date $DATE
 */
public class Socket2Http {
    public static void main(String[] args) {

        try {
            // 创建套接字
            Socket socket = new Socket("www.weiyuyang.com", 80);
            // 获取输出流
            OutputStream outputStream = socket.getOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            // 第一个\r\n后 服务器开始读取请求头，第二个\r\n 表示没有请求头
            outputStreamWriter.write("GET / HTTP/1.0\r\n\r\n");
            outputStreamWriter.flush();

            InputStream inputStream = socket.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}