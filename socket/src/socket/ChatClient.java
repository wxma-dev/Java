package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClient {

	public static void main(String[] args) {
		try {
			System.out.println("请输入聊天内容，将会发送到服务器");
			Socket socket = new Socket("localhost", 10001);
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

			while (true) {
				String msg = reader.readLine();
				out.println(msg);
				out.flush();
				if (msg.equals("bye")) {
					break;
				}
				System.out.println(in.readLine());
			}
			socket.close();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}