package com.competition.db.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.competition.db.dao.AlbumPhotoDao;
import com.competition.db.dao.UserAlbumDao;
import com.competition.db.pojo.AlbumPhoto;
import com.competition.db.pojo.UserAlbum;
import com.competition.db.service.AlbumPhotoService;
import com.competition.db.service.UserAlbumService;
import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import com.opensymphony.xwork2.ActionSupport;

public class AlbumPhotoAction extends ActionSupport {
	//所有要上传的文件，即图片
	private List<File> images;
	//
	private String savePath;
	
	private UserAlbum album;
	
	private AlbumPhoto photo;
	
	private UserAlbumService uas;
	
	private AlbumPhotoService aps;
	//用于记录上传成功的照片数
	public int count=0;
	//全部上传成功
	public static String UPLOAD_FINISH_ALL = "upload_finish_all";
	//部分上传成功
	public static String UPLOAD_FINISH_NOT_ALL = "upload_finish_not_all";
	//上传失败
	public static String UPLOAD_FAILURE = "upload_failure";
	//
	public static String UPLOAD_NO_LOCATION = "upload_no_location";
	
	public List<File> getImages() {
		return images;
	}

	public void setImages(List<File> images) {
		this.images = images;
	}

	public UserAlbum getAlbum() {
		return album;
	}

	public void setAlbum(UserAlbum album) {
		this.album = album;
	}

	public AlbumPhoto getPhoto() {
		return photo;
	}

	public void setPhoto(AlbumPhoto photo) {
		this.photo = photo;
	}

	public String getSavePath() {
		return ServletActionContext.getServletContext().getRealPath(savePath);
	}
	//从Struts.xml注入
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
	 * 上传照片
	 * @return 无法创建文件则返回错误提示，
	 */
	public String uploadPhotos(){
		boolean isSave=false;
		for(int i=0; i<images.size(); i++){
			isSave = savePhoto(i);
			if(isSave == true){
				count++;
			}
		}
		if(count == images.size()){
			return UPLOAD_FINISH_ALL;
		}else if(count !=images.size() && count >0){
			return UPLOAD_FINISH_NOT_ALL;
		}else{
			return UPLOAD_FAILURE;
		}
	}
	/**
	 * 上传图片
	 * @return
	 */
	public boolean savePhoto(int i){
		try{
			File inFile = images.get(i);
			FileInputStream fis = new FileInputStream(images.get(i));
			String inFileName = inFile.getName();
			//提取后缀
			String prefix = inFileName.substring(inFileName.lastIndexOf(".") + 1);
			//检查后缀
			if(prefix=="png" || prefix == "jpeg"){
				String savePath = getSavePath() + File.separator + (uas.getPhotoNum(album)+1) + prefix;	//如何把savePath封装到AlbumPhoto中
				File file = new File(savePath);
				if(!file.exists()){
					return false;
				}
				FileOutputStream fos = new FileOutputStream(file);
				byte[] buffer = new byte[1024];
				int len=0;
				while((len = fis.read())>0){
					fos.write(buffer,0,len);
				}
				//album需要曾经持久化
				aps.addPhotoByAluObj(album, photo);
			}
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	public String getLocation(File file){
		String latitude =null;
		String longtitude = null;
		try {
			Metadata metadata = ImageMetadataReader.readMetadata(file);
			for(Directory directory:metadata.getDirectories()){
				for(Tag tag:directory.getTags()){
					String tagName = tag.getTagName();
					String desc = tag.getDescription();
					if(tagName.equals("GPS Latitude")){
						latitude = desc;
					}
					if(tagName.equals("GPS Longitude")){
						longtitude = desc;
					}
				}
			}
			if(latitude != null && longtitude != null){
				return latitude + "," + longtitude;
			}
			else{
				return UPLOAD_NO_LOCATION;
			}
		} catch (ImageProcessingException e) {
			e.printStackTrace();
			return UPLOAD_NO_LOCATION;
		} catch (IOException e) {
			e.printStackTrace();		
			return UPLOAD_FAILURE;

		}
	}
}
