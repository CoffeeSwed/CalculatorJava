package patternfinder.pattern.factories.results;

public class Results {
	private boolean didEditPattern;
	
	private boolean hasWarning;
	
	private boolean hasError;
	
	private String warningString, errorString;

	public boolean didEditString() {
		return didEditPattern;
	}

	public void setDidEditString(boolean didEdit) {
		this.didEditPattern = didEdit;
	}

	public boolean isHasWarning() {
		return hasWarning;
	}

	public void setHasWarning(boolean hasWarning) {
		this.hasWarning = hasWarning;
	}

	public boolean isHasError() {
		return hasError;
	}

	public void setHasError(boolean hasError) {
		this.hasError = hasError;
	}

	public String getWarningString() {
		return warningString;
	}

	public void setWarningString(String warningString) {
		this.warningString = warningString;
	}

	public String getErrorString() {
		return errorString;
	}

	public void setErrorString(String errorString) {
		this.errorString = errorString;
	}
	
	public Results(boolean didEdit, boolean haswarning, boolean haserror,
			String warning, String error) {
		this.setDidEditString(didEdit);
		this.setHasWarning(haswarning);
		this.setHasError(haserror);
		this.setWarningString(warning);
		this.setErrorString(error);
	}
	
	public Results(boolean didEdit) {
		this(didEdit,false,false,null,null);
	}
}
