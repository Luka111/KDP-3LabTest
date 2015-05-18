package ponovo;

import java.io.Serializable;
import rs.ac.bg.etf.kdp.zaki.*;

public class MessageImpl120079<T> implements Serializable{
	Message<T> msg;
	Prioritet prioritet;
	long ttl;
	public MessageImpl120079(Message<T> msg, Prioritet prioritet, long ttl){
		this.msg=msg;
		this.prioritet=prioritet;
		this.ttl=ttl;
	}

}
