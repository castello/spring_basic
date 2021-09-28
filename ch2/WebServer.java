import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {
        public static void main(String[] args) throws Exception {
                ServerSocket serverSocket = new ServerSocket(8888);

                System.out.println("서버가 요청을 받을 준비가 되었습니다.");
                System.out.println("연결을 기다리는 중...");
                Socket socket = serverSocket.accept();
                System.out.println("연결되었습니다.");

                InputStream in = socket.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(in));

                int data = 0;
                while ((data = br.read()) != -1)
                        System.out.print((char) data);

                br.close();
                socket.close();
        }
}
