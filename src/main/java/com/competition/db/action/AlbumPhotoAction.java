package com.competition.db.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.springframework.jdbc.support.incrementer.HsqlMaxValueIncrementer;

import com.competition.db.dao.AlbumPhotoDao;
import com.competition.db.dao.UserAlbumDao;
import com.competition.db.pojo.AlbumPhoto;
import com.competition.db.pojo.User;
import com.competition.db.pojo.UserAlbum;
import com.competition.db.service.AlbumPhotoService;
import com.competition.db.service.UserAlbumService;
import com.opensymphony.xwork2.ActionSupport;

public class AlbumPhotoAction extends ActionSupport {
	//
	private File upload;
	//
	private String uploadContentType;
	//
	private String uploadFileName;
	//
	private String savePath;
	
	private UserAlbum album;
	
	private AlbumPhoto photo;
	
	private UserAlbumService uas;
	
	private AlbumPhotoService aps;
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser() {
		this.user = (User)ServletActionContext.getServletContext().getAttribute("user");
	}

	private Map<String, Object> map = new HashMap<String,Object>();
	
	
	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	
	public UserAlbumService getUas() {
		return uas;
	}

	public void setUas(UserAlbumService uas) {
		this.uas = uas;
	}

	public AlbumPhotoService getAps() {
		return aps;
	}

	public void setAps(AlbumPhotoService aps) {
		this.aps = aps;
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5141822686342883246L;

	/**
	 * 尝试上传单张照片
	 * @return 无法创建文件则返回错误提示，
	 */
	public String uploadPhoto(){
		try{

			String savePath = getSavePath() + File.separator + (uas.getPhotoNum(album)+1);	//如何把savePath封装到AlbumPhoto中
			File file = new File(savePath);
			
			if(!file.exists()){
				return ERROR;
			}
			FileOutputStream fos = new FileOutputStream(file);
			FileInputStream fis = new FileInputStream(getUpload());
			byte[] buffer = new byte[1024];
			int len=0;
			while((len = fis.read())>0){
				fos.write(buffer,0,len);
			}
			return SUCCESS;
		}catch(Exception e){
			return ERROR;
		}
	}
	

}
