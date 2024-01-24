package calculator.usageinformer;

import java.util.ArrayList;
import java.util.Iterator;

public class UsageInformationIterator<UsageInformation> implements Iterator<UsageInformation>{
	private ArrayList<UsageInformation> information;
	public UsageInformationIterator(ArrayList<UsageInformation> copy) {
		this.information = new ArrayList<UsageInformation>();
		for(UsageInformation t : copy) {
			this.information.add(t);
		}
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return this.information.size() != 0;
	}

	@Override
	public UsageInformation next() {
		// TODO Auto-generated method stub
		return this.information.remove(0);
	}
}
