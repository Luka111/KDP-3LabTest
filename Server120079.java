package ponovo;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import rs.ac.bg.etf.kdp.zaki.*;


public class Server120079 {

	public static void main(String[] args) {
		int port = Integer.parseInt(args[0]);
		MessageBox<Object> buffer = (MessageBox<Object>) new ListMessageBox120079<Object>(2);

		ExecutorService executor=Executors.newFixedThreadPool(5);
		
		try (ServerSocket server = new ServerSocket(port);) {

			while (true) {
				Socket socket = server.accept();

				executor.execute(new WorkingThread120079(socket, buffer));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
