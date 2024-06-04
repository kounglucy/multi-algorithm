package step02.chat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		// serverSocket
		try {
			ServerSocket serverSocket = new ServerSocket();
			// bind() : 서버의 ip 주소와 port 설정, 통신 시작
			serverSocket.bind(new InetSocketAddress("localhost", 9999));
			
			while(true) {
				// step01 : 연결 
				Socket socket = serverSocket.accept();
				InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
				System.out.println(isa.getHostName() + "님이 입장하셨습니다.");
				
				// step02 : 통신1(클라이언트 -> 서버 : 메세지를 확인)
				InputStream is = socket.getInputStream();
				
				byte[] requestMsg = new byte[100];
				int countByte = is.read(requestMsg);
				
				String msg = new String(requestMsg, 0, countByte, "UTF-8");
				System.out.println("메세지를 정상적으로 받았습니다 : " + msg);
				
				// step03 : 통신2(서버 -> 클라이언트)
				OutputStream os = socket.getOutputStream();
				
				String responseMsg = "점심 시간 이니까, 점메추좀?";
				os.write(responseMsg.getBytes());
				os.flush();
				System.out.println("메세지 전송이 완료되었습니다.");
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
