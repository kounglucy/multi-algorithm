package step03.threadpool;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client{
	static Socket socket;
	
	static void startClient() {
		Thread thread = new Thread() {
			@Override
			public void run() {
				try {
					// 소켓 생성 및 연결 요청
					socket = new Socket();
					socket.connect(new InetSocketAddress("localhost", 8888));
				} catch(Exception e) {
					System.out.println("[서버와 통신이 불가능 합니다]");
					
					if(!socket.isClosed()) { 
						stopClient(); 
					}
					
					return;
				}
				// 서버에서 보낸 데이터 받기
				receive();
			}
		};
		// 스레드 시작
		thread.start();
	}
	
	static void stopClient() {
		try {
			System.out.println("[클라이언트 연결을 종료합니다]");
			// 연결 끊기
			if(socket!=null && !socket.isClosed()) {
				socket.close();
			}
		} catch (IOException e) {}
	}	
	
	static void receive() {
		while(true) {
			try {
				byte[] byteArr = new byte[100];
				InputStream inputStream = socket.getInputStream();
				
				// 데이터 입력
				int readByteCount = inputStream.read(byteArr);
				
				// 정상적으로 close()
				if(readByteCount == -1) { 
					throw new IOException(); 
				}
				
				// 문자열로 변환
				String data = new String(byteArr, 0, readByteCount, "UTF-8");
				
				System.out.println("[받은 데이터] "  + data);
			} catch (Exception e) {
				System.out.println("[서버와 통신이 불가능 합니다]");
				stopClient();
				break;
			}
		}
	}
	
	static void send(String data) {
		// 스레드 생성
		Thread thread = new Thread() {
			@Override
			public void run() {
				try {
					// 데이터 전송
					byte[] byteArr = data.getBytes("UTF-8");
					OutputStream outputStream = socket.getOutputStream();
					
					// 데이터 쓰기
					outputStream.write(byteArr);
					outputStream.flush();
					System.out.println("[데이터 전송 완료]");
				} catch(Exception e) {
					System.out.println("[서버와 통신이 불가능 합니다]");
					stopClient();
				}				
			}
		};
		thread.start();
	}
	
	public static void main(String[] args) {
		startClient();
		while(true) {
			Scanner sc = new Scanner(System.in);
			String msg = sc.nextLine();
			// Stop Client 입력 : 클라이언트 연결 종료
			if(msg.equals("Stop Client"))
				break;
			send(msg);
		}
		stopClient();
	}
}
