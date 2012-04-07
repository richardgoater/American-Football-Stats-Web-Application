package uk.co.richardgoater.stats.upload.mvc;

import uk.co.richardgoater.stats.upload.UploadResponse;

public class WebUploadResponse implements UploadResponse {
	
	StringBuilder messageBuilder = new StringBuilder();
	
	public WebUploadResponse() {}

	public String getMessage() {
		return messageBuilder.toString();
	}
	
	@Override
	public void appendLine(String text) {
		messageBuilder.append(text + separator());
	}
	
	@Override
	public void appendBoldLine(String text) {
		messageBuilder.append("<b>" + text + "</b>" + separator());		
	}

	@Override
	public void appendError(String text) {
		messageBuilder.append("<span class=\"error\">Error: " + text + "</span>" + separator());
	}

	@Override
	public void appendBlankLine() {
		messageBuilder.append(separator());		
	}
	
	@Override
	public void clearMessage() {
		messageBuilder.setLength(0);
	}
	
	@Override
	public String separator() {
		return "<br/>";
	}

}
