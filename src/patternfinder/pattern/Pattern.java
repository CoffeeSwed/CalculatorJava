package patternfinder.pattern;

public abstract class Pattern implements IsProtected {
	public abstract String getName();
			
	public abstract Object getValue();

	// Should only be changed when the one put the tag says so!
	@Override
	public boolean taggedAsNotProtected() {
		return true;
	}
}
