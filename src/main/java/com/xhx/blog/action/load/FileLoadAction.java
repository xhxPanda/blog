package com.xhx.blog.action.load;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.servlet.ServletContext;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.xhx.blog.common.action.BaseAction;
import com.xhx.blog.domain.UpLoadFile;
import com.xhx.blog.util.JsonUtil;

public class FileLoadAction extends BaseAction<UpLoadFile>{
	
	private String filePath;
	private String file_dataFileName;
	private File file_data;
	
	
	public String add(){
		String path = "upload\\image";
		String rootPath = ((ServletContext)ActionContext.getContext().get(ServletActionContext.SERVLET_CONTEXT)).getRealPath("/");
		String filePath = rootPath + path + getFile_dataFileName();
		
		try {
			boolean flag = saveFile(filePath, file_data);
			
			if(flag==true){
				result = JsonUtil.succObject(new UpLoadFile(filePath));
			}else{
				return ERROR;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public boolean saveFile(String path, File file)throws Exception {
		try {
			FileOutputStream fos = new FileOutputStream(path);
			FileInputStream fis = new FileInputStream(file);
			byte[] buffer = new byte[1024 * 2];
			int len = 0;
			while ((len = fis.read(buffer)) > 0) {
				fos.write(buffer, 0, len);
			}
		} catch (Exception e) {
			throw e;
		}
		return true;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFile_dataFileName() {
		return file_dataFileName;
	}

	public void setFile_dataFileName(String file_dataFileName) {
		this.file_dataFileName = file_dataFileName;
	}

	public File getFile_data() {
		return file_data;
	}

	public void setFile_data(File file_data) {
		this.file_data = file_data;
	}


}
