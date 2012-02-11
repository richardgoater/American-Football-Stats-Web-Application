package uk.co.richardgoater.stats.tests;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.web.multipart.MultipartFile;

public class TestFile implements MultipartFile {

	@Override
	public byte[] getBytes() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getContentType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InputStream getInputStream() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getOriginalFilename() {
		// TODO Auto-generated method stub
		return "test";
	}

	@Override
	public long getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	private boolean isEmpty;

	public void isEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return isEmpty;
	}

	@Override
	public void transferTo(File paramFile) throws IOException,
			IllegalStateException {
		// TODO Auto-generated method stub

	}
}