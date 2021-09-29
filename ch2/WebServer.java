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

            byte[] byteArr = new byte[8192];

            in.read(byteArr);
            String request = new String(byteArr);
                
            String[] lines = request.split("\n");
            System.out.println("request="+request);
            System.out.println("line cnt="+lines.length);

            System.out.println(lines[0]); // GET /ch2/getYoil HTTP/1.1
            System.out.println(lines[0].split(" ")[1]);// /ch2/getYoil

        }
    }
