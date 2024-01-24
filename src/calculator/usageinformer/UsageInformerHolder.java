package calculator.usageinformer;

import java.util.ArrayList;
import java.util.Iterator;

public class UsageInformerHolder implements Iterable<UsageInformation> {

	private ArrayList<UsageInformation> usageInformations;
	
	public UsageInformerHolder() {
		// TODO Auto-generated constructor stub
		this.usageInformations = new ArrayList<UsageInformation>();
	}
	
	@Override
	public Iterator<UsageInformation> iterator() {
		// TODO Auto-generated method stub
		return new UsageInformationIterator<UsageInformation>(this.usageInformations);
	}
	
	

}
