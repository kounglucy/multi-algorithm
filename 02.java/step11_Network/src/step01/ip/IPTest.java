package step01.ip;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

public class IPTest {
	public static void main(String[] args) {
		// IP
		try {
			// 로컬 IP
			InetAddress local = InetAddress.getLocalHost();
//			System.out.println(local);
			
			// 외부 IP
//			InetAddress remote = InetAddress.getByName("naver.com");
//			InetAddress[] remote = InetAddress.getAllByName("naver.com");
//			for(InetAddress address : remote) {
//				System.out.println(address);
//			}
			
			// URL
			URL url = new URL("https://www.naver.com:443/index.html");
			System.out.println(url.getDefaultPort());
			
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
