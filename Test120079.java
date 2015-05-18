package ponovo;
import rs.ac.bg.etf.kdp.zaki.*;


public class Test120079 {

	public static void main(String[] args) {
		// MessageBox<String> buffer = new ListMessageBox<String>(2);
		// MessageBox<String> buffer = new LockMessageBox<String>(2);
		MessageBox<byte[]> buffer = new RemoteMessageBox120079<byte[]>(args[0],
				Integer.parseInt(args[1]));

		Put120079 put = new Put120079(buffer);
		Get120079 get = new Get120079(buffer);
		put.setVisible(true);
		get.setVisible(true);
	}

}
