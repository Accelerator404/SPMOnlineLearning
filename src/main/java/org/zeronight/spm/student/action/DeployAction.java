package org.zeronight.spm.student.action;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.zeronight.spm.model.Server;
import org.zeronight.spm.model.Student;
import org.zeronight.spm.model.StudentGroup;
import org.zeronight.spm.model.User;
import org.zeronight.spm.model.Work;
import org.zeronight.spm.student.service.IStudentService;

import com.opensymphony.xwork2.ActionSupport;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;

public class DeployAction extends ActionSupport {
	private static String ACCESS_KEY = "ZWk08oKr_GnRiv-T-AnXaDs2eLNB2qztD9lhfouX";
	private static String SECRET_KEY = "iU_rF_IW5RD4mAwX4m5WeuXWet-Tw2s9ZbKmd8eH";
	
	// 要上传的空间
	private static String BUCKET_NAME = "chankc";

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Work work;
	private File upload;
	private String uploadContentType;
	private String uploadFileName;
	private List<Server> servers;
	private String sourceCode;
	@Autowired
	private IStudentService studentService;

	public Work getWork() {
		return work;
	}

	public void setWork(Work work) {
		this.work = work;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	@Override
	public String execute() throws Exception {
		servers = studentService.getAllServers();
		Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
		UploadManager uploadManager = new UploadManager();
		String username;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		} else {
			username = principal.toString();
		}
		User user = studentService.getUserByUsername(username);
		StudentGroup group = user.getStudent().getStudentGroup();
		if(group==null)return "no_group";
		work = group.getWork();
		if(upload==null)return INPUT;
		if(work==null){
			work = new Work();
			work.setStudentGroup(group);
		}
		work.setProject("http://o8m79d0cw.bkt.clouddn.com/"+uploadFileName);
		work.setSourceCode(sourceCode);
		try{
			uploadManager.put(upload, uploadFileName, auth.uploadToken(BUCKET_NAME));
		}catch(QiniuException e){
			Response r = e.response;
			// 请求失败时打印的异常的信息
			System.out.println(r.toString());
			try {
				// 响应的文本信息
				System.out.println(r.bodyString());
			} catch (QiniuException e1) {
				// ignore
			}
		}
		studentService.addOrUpdateWork(work);
		return SUCCESS;
	}

	public List<Server> getServers() {
		return servers;
	}

	public void setServers(List<Server> servers) {
		this.servers = servers;
	}

	public String getSourceCode() {
		return sourceCode;
	}

	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}
}
