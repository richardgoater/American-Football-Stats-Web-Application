package uk.co.richardgoater.stats.upload.mvc;

public class UploadResponse {
	
	String result;
	
	public UploadResponse() {}
	
	public UploadResponse(String result) {
		this.result = result;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
