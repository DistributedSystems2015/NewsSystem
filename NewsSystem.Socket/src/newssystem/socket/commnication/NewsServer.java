package newssystem.socket.commnication;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class NewsServer implements Runnable {
	@Override
	public void run() {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket();
			SocketAddress endpoint = new InetSocketAddress("localhost", 11001);
			serverSocket.bind(endpoint, 10);
			System.out.println("Server started.");
			while (true) {
				Socket clientSocket = serverSocket.accept();
				NewsWorker worker = new NewsWorker(clientSocket);
				worker.run();
            }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(serverSocket != null) {
				try {
					serverSocket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
