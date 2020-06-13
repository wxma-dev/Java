package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
	
	StringBuffer a;
	
	public static void main(String[] args) {
		try
		{
			System.out.println("服务已启动。。。客户端可连接。。");
			Socket socket = new ServerSocket(50509).accept();
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			while (true) {
				String msg = in.readLine();
				System.out.println("服务端收到的信息:" + msg);
				out.println("server receive:" + msg);
				out.flush();
				if (msg.equals("bye")) {
					break;
				}
			}
			socket.close();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

