package step03.threadpool;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server{
	// 스레드풀
	static ExecutorService executorService;
	static ServerSocket serverSocket;
	static List<Client> connections = new Vector<Client>();
	
	// 서버 시작
	static void startServer() {
		// 스레드풀 생성
		executorService = Executors.newFixedThreadPool(
			Runtime.getRuntime().availableProcessors()
	    );
		
		// 서버 소켓 생성 및 바인딩
		try {
			serverSocket = new ServerSocket();		
			serverSocket.bind(new InetSocketAddress("localhost", 8888));
		} catch(Exception e) {
			if(!serverSocket.isClosed()) { 
				stopServer(); 
			}
			return;
		}
		
		// 수락 작업 생성
		Runnable runnable = new Runnable() {
			@Override
			public void run() {	
				System.out.println("[서버를 시작합니다]");
				while(true) {
					try {
						// 연결 수락
						Socket socket = serverSocket.accept();
						System.out.println("[연결을 수락합니다 : " + socket.getRemoteSocketAddress()  + ": " + Thread.currentThread().getName() + "]");		
						// 클라이언트 접속 객체 저장
						Client client = new Client(socket);
						connections.add(client);
						System.out.println("[연결된 클라이언트 수: " + connections.size() + "]");
					} catch (Exception e) {
						if(!serverSocket.isClosed()) { 
							stopServer(); 
						}
						break;
					}
				}
			}
		};
		// 스레드풀의 작업 처리
		executorService.submit(runnable);
	}
	
	// 서버 종료
	static void stopServer() {
		try {
			// 모든 소켓 close
			Iterator<Client> iterator = connections.iterator();
			while(iterator.hasNext()) {
				Client client = iterator.next();
				client.socket.close();
				iterator.remove();
			}
			// 서버 소켓 close
			if(serverSocket!=null && !serverSocket.isClosed()) { 
				serverSocket.close(); 
			}
			// 스레드풀 종료
			if(executorService!=null && !executorService.isShutdown()) { 
				executorService.shutdown(); 
			}
			System.out.println("[서버 멈춤]");
		} catch (Exception e) { }
	}	
	
	// 클라이언트
	static class Client {
		Socket socket;
		
		Client(Socket socket) {
			this.socket = socket;
			receive();
		}
		
		// 받기
		void receive() {
			// 받기 작업 생성
			Runnable runnable = new Runnable() {
				@Override
				public void run() {
					try {
						while(true) {
							byte[] byteArr = new byte[100];
							InputStream inputStream = socket.getInputStream();
							
							// 데이터 받기
							int readByteCount = inputStream.read(byteArr);
							
							// 클라이언트 Socket의 close()
							if(readByteCount == -1) {  
								throw new IOException(); 
							}
							
							System.out.println("[요청 처리 : " + socket.getRemoteSocketAddress() + ": " + Thread.currentThread().getName() + "]");
							
							// 데이터 변환
							String data = new String(byteArr, 0, readByteCount, "UTF-8");
							
							// Stop Server 요청시 서버 종료
							if(data.equals("Stop Server")) {
								stopServer();
							}
							
							// 모든 클라이언트에게 데이터 전송
							for(Client client : connections) {
									client.send(data); 
							}
						}
					} catch(Exception e) {
						try {
							connections.remove(Client.this);
							System.out.println("[클라이언트 통신 불가능 : " + socket.getRemoteSocketAddress() + ": " + Thread.currentThread().getName() + "]");
							socket.close();
						} catch (IOException e1) {}
					}
				}
			};
			// 스레드풀에서 처리
			executorService.submit(runnable);
		}
		
		// 보내기
		void send(String data) {
			// 보내기 작업 생성
			Runnable runnable = new Runnable() {
				@Override
				public void run() {
					try {
						// 데이터 보내기
						byte[] byteArr = data.getBytes("UTF-8");
						OutputStream outputStream = socket.getOutputStream();
						// 데이터 쓰기
						outputStream.write(byteArr);
						outputStream.flush();
					} catch(Exception e) {
						try {
							System.out.println("[클라이언트 통신 불가눙 : " + socket.getRemoteSocketAddress() + ": " + Thread.currentThread().getName() + "]");
							connections.remove(Client.this);
							socket.close();
						} catch (IOException e2) {}
					}
				}
			};
			// 스레드풀에서 처리
			executorService.submit(runnable);
		}
	}
	
	public static void main(String[] args) {
		startServer();
	}
}
