package org.zeronight.spm;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.dispatcher.multipart.MultiPartRequest;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.util.WebUtils;

public class SpringMultipartParser implements MultiPartRequest {

	private List<String> errors = new ArrayList<String>();

	private MultiValueMap<String, MultipartFile> multipartMap;

	private MultipartHttpServletRequest multipartRequest;

	private MultiValueMap<String, File> multiFileMap = new LinkedMultiValueMap<String, File>();
	
	private File dir;

	@Override
	public void parse(HttpServletRequest request, String saveDir) throws IOException {
		multipartRequest = WebUtils.getNativeRequest(request, MultipartHttpServletRequest.class);
		if (multipartRequest == null) {
			errors.add("Unable to MultipartHttpServletRequest");
			return;
		}
		multipartMap = multipartRequest.getMultiFileMap();
		dir = new File(saveDir);
		if(!dir.exists())dir.mkdirs();
		// for(Entry<String, List<MultipartFile>> fileEntry :
		// multipartMap.entrySet()) {
		// String fieldName = fileEntry.getKey();
		// for(MultipartFile file : fileEntry.getValue()) {
		// File temp = File.createTempFile("upload", ".dat");
		// file.transferTo(temp);
		// multiFileMap.add(fieldName, temp);
		// }
		// }
	}

	@Override
	public Enumeration<String> getFileParameterNames() {
		return Collections.enumeration(multipartMap.keySet());
	}

	@Override
	public String[] getContentType(String fieldName) {
		List<MultipartFile> files = multipartMap.get(fieldName);
		if (files == null) {
			return null;
		}
		String[] contentTypes = new String[files.size()];
		int i = 0;
		for (MultipartFile file : files) {
			contentTypes[i++] = file.getContentType();
		}
		return contentTypes;
	}

	@Override
	public File[] getFile(String fieldName) {
		List<MultipartFile> files = multipartMap.get(fieldName);
		File[] result = new File[files.size()];
		for(int i=0;i<result.length;i++){
			try {
				File temp = File.createTempFile("upload", ".dat",dir);
				files.get(i).transferTo(temp);
				result[i]=temp;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public String[] getFileNames(String fieldName) {
		List<MultipartFile> files = multipartMap.get(fieldName);
		if (files == null) {
			return null;
		}
		String[] fileNames = new String[files.size()];
		int i = 0;
		for (MultipartFile file : files) {
			fileNames[i++] = file.getOriginalFilename();
		}
		return fileNames;
	}

	@Override
	public String[] getFilesystemName(String fieldName) {
		List<File> files = multiFileMap.get(fieldName);
		if (files == null) {
			return null;
		}
		String[] fileNames = new String[files.size()];
		int i = 0;
		for (File file : files) {
			fileNames[i++] = file.getName();
		}
		return fileNames;
	}

	@Override
	public String getParameter(String name) {
		return multipartRequest.getParameter(name);
	}

	@Override
	public Enumeration<String> getParameterNames() {
		return multipartRequest.getParameterNames();
	}

	@Override
	public String[] getParameterValues(String name) {
		return multipartRequest.getParameterValues(name);
	}

	@Override
	public List<String> getErrors() {
		return errors;
	}

	@Override
	public void cleanUp() {
		for (List<File> files : multiFileMap.values()) {
			for (File file : files) {
				file.delete();
			}
		}
	}

}
