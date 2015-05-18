package ponovo;
import rs.ac.bg.etf.kdp.zaki.*;

public class PrioritetImpl implements Prioritet {
	
	int prioritet;
	@Override
	public int compareTo(Prioritet arg0) {
		if(this.prioritet>=arg0.getPrioritet())
			return 1;
		else
		  return 0;
	}

	@Override
	public void setPrioritet(int prioritet) {
		this.prioritet=prioritet;
	}

	@Override
	public int getPrioritet() {
		return prioritet;
	}

}
