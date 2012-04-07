package uk.co.richardgoater.stats.upload;

public interface UploadResponse {

	String getMessage();
	
	void appendLine(String text);
	
	void appendBoldLine(String text);
	
	void appendError(String text);
	
	void appendBlankLine();
	
	void clearMessage();
	
	String separator();
}
