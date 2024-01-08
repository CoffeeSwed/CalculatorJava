package calculator.factories.storagefactory;

import java.util.ArrayList;

import calculator.patterns.Function;
import patternfinder.PatternString;
import patternfinder.pattern.Decimal;
import patternfinder.pattern.Pattern;
import patternfinder.pattern.Text;
import patternfinder.pattern.factories.Factory;
import patternfinder.pattern.factories.results.Results;

public class StorageFactory extends Factory{

	private ArrayList<StorageFactoryEntries> arrayList;

	public StorageFactory(ArrayList<StorageFactoryEntries>  arrayList2) {
		this.setArrayList(arrayList2);
		if(this.getArrayList() == null) {
			this.setArrayList(new ArrayList<StorageFactoryEntries>());
		}
	}
	
	private StorageFactoryEntries getEntryForNameOrMakeOne(String name) {
		for(StorageFactoryEntries entry : this.getArrayList()) {
			if(entry.getName().equals(name)) {
				return entry;
			}
		}
		
		StorageFactoryEntries entry = new StorageFactoryEntries(name,null);
		this.getArrayList().add(entry);
		return entry;
	}
	
	private void storeAs(Pattern value, String name) {
		StorageFactoryEntries entry = this.getEntryForNameOrMakeOne(name);
		entry.setValue(value);
	}
	
	private Pattern getPatternForEntry(String name) {
		for(StorageFactoryEntries entry : this.getArrayList()) {
			if(entry.getName().equals(name)) {
				return entry.getValue();
			}
		}
		return new Decimal(0.0);
	}
	
	@Override
	public Results editPatternString(PatternString patternstr) {
		// TODO Auto-generated method stub
		
		for(int i = 0; i < patternstr.getPatterns().size();i++) {
			if(patternstr.isPatternAt(i, Function.class)) {
				Function function = (Function) patternstr.getPattern(i);

				if(function.getName().equalsIgnoreCase("storeas")) {
					this.storeAs(function.getValue().getValues().get(0),((Text)function.getValue().getValues().get(1)).getValue());
					patternstr.getPatterns().set(i, function.getValue().getValues().get(0));
					return this.createDefaultResultString(true);
				}
				if(function.getName().equalsIgnoreCase("load")) {
					Text text = (Text)function.getValue().getValues().get(0);
					patternstr.getPatterns().set(i,getPatternForEntry(text.getValue()));
					return this.createDefaultResultString(true);
				}
			}
		}
		
		return this.createDefaultResultString(false);

	}


	public ArrayList<StorageFactoryEntries> getArrayList() {
		return arrayList;
	}


	public void setArrayList(ArrayList<StorageFactoryEntries> arrayList) {
		this.arrayList = arrayList;
	}

}
