package cn.juejin.netty.socket;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;

/**
 * @author pengfei.zhao
 * @date 2021/1/2 9:12
 */
public class IOClient {
    public static void main(String[] args) {
        new Thread(() -> {
            try {
                Socket socket = new Socket("127.0.0.1", 8000);
                while (true) {
                    try {
                        socket.getOutputStream().write((new Date() + "hello, world").getBytes());
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
