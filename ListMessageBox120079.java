package ponovo;

import java.util.LinkedList;
import java.util.List;
import rs.ac.bg.etf.kdp.zaki.*;

public class ListMessageBox120079<T> implements MessageBox<T> {
	List<Message<T>> buffer;
	int cap;

	public ListMessageBox120079(int cap) {
		super();
		this.cap = cap;
		buffer = new LinkedList<Message<T>>();
	}

	@Override
	public synchronized void send(Message<T> msg, Prioritet prioritet, long ttl) {
		while (buffer.size() == cap) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		int i=buffer.size();
		if(prioritet!=null){
			i=0;
		}
		buffer.add(i,msg);
		notifyAll();
	}

	@Override
	public synchronized Message<T> receive(Status status, long ttd) {
		while (buffer.size() == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Message<T> result = buffer.remove(0);
		notifyAll();
		return result;
	}

}
