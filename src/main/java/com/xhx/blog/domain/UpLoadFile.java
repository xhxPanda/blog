package com.xhx.blog.domain;

public class UpLoadFile {
	
	private Long id;
	private String fileName;
	private String FilePath;
	private String FileType;
	
	public UpLoadFile(){}
	
	public UpLoadFile(String FilePath){
		this.FilePath = FilePath;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFilePath() {
		return FilePath;
	}
	public void setFilePath(String filePath) {
		FilePath = filePath;
	}
	public String getFileType() {
		return FileType;
	}
	public void setFileType(String fileType) {
		FileType = fileType;
	}

}
