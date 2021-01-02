package cn.juejin.netty.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author pengfei.zhao
 * @date 2021/1/2 9:05
 */
public class IOServer {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8000);

        new Thread(() -> {
            while (true) {
                try {
                    Socket socket = serverSocket.accept();
                    InputStream is = socket.getInputStream();

                    new Thread(() -> {
                        try {
                            byte[] data = new byte[1024];

                            int len;
                            while ((len = is.read(data)) != -1) {
                                System.out.println(new String(data, 0, len));
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }).start();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }).start();
    }
}
