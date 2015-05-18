package ponovo;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import rs.ac.bg.etf.kdp.zaki.*;


public class WorkingThread120079 extends Thread {
	Socket socket;
	MessageBox<Object> buffer;
	Prioritet p;
	public WorkingThread120079(Socket socket, MessageBox<Object> buffer) {
		super();
		this.socket = socket;
		this.buffer = buffer;
		p=new PrioritetImpl();
	}

	@SuppressWarnings("unchecked")
	public void run() {

		try (Socket socket = this.socket;
				ObjectOutputStream out = new ObjectOutputStream(
						socket.getOutputStream());
				ObjectInputStream in = new ObjectInputStream(
						socket.getInputStream());) {

			String opr = (String) in.readObject();
			Message<Object> msg;

			switch (opr) {
			case "send":
				MessageImpl120079<Object> impl=null;
				impl = (MessageImpl120079<Object>) in.readObject();
				buffer.send(impl.msg, impl.prioritet, impl.ttl);
				out.writeObject("OK");
				break;
			case "receive":
				msg = buffer.receive(null, 0);
				try{
					out.writeObject(msg);
				}catch(Exception e){
					p.setPrioritet(MAX_PRIORITY);
					buffer.send(msg, p, 0);
				}
				in.readObject();
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
