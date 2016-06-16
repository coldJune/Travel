package com.competition.db.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.jdbc.support.incrementer.HsqlMaxValueIncrementer;

import com.competition.db.dao.AlbumPhotoDao;
import com.competition.db.dao.UserAlbumDao;
import com.competition.db.pojo.AlbumPhoto;
import com.competition.db.pojo.User;
import com.competition.db.pojo.UserAlbum;
import com.competition.db.pojo.UserFollow;
import com.competition.db.service.AlbumPhotoService;
import com.competition.db.service.UserAlbumService;
import com.competition.db.service.UserFollowService;
import com.competition.db.service.UserService;
import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AlbumPhotoAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5141822686342883246L;

	// 所有要上传的文件，即图片
	private List<File> images;
	// 所要上传文件的文件名
	private List<String> FileNames;

	private String savePath;

	private UserAlbum album;

	private AlbumPhoto photo;

	private String diary;

	private String releaseResult;
	
	private UserFollowService ufs;
	
	private UserAlbumService uas;

	private AlbumPhotoService aps;
	// 用于记录上传成功的照片数
	public int count = 0;
	// 全部上传成功
	public static String UPLOAD_FINISH_ALL = "upload_finish_all";
	// 部分上传成功
	public static String UPLOAD_FINISH_NOT_ALL = "upload_finish_not_all";
	// 上传失败
	public static String UPLOAD_FAILURE = "upload_failure";
	//
	public static String UPLOAD_NO_LOCATION = "upload_no_location";

	private User user;

	private UserAlbum userAlbum;

	// 临时注入
	private SessionFactory sessionFactory;

	private static Map<String, Object> map = new HashMap<String, Object>();

	/**
	 * 上传照片
	 * 
	 * @return 无法创建文件则返回错误提示
	 */
	public String uploadPhotos() {
		boolean isSave = false;

		Session sess = sessionFactory.openSession();
		Transaction tx = sess.beginTransaction();
		User user = new User();
		user.setM_sUserName("JiangLin");
		user.setM_sUserPass("jianglin");
		sess.save(user);
		tx.commit();

		Transaction tx2 = sess.beginTransaction();
		user = (User) sess.get(User.class, 1);
		tx2.commit();
		sess.close();

		// 获取User对象
		// User user = (User)
		// ActionContext.getContext().getSession().get("userinfo");
		map.put("userName", user.getM_sUserName());

		// 创建一条记录且持久化
		userAlbum = new UserAlbum();
		userAlbum.setM_DAlbumCreatedTime(new Date(System.currentTimeMillis()));
		userAlbum.setM_iPhotoNum(images.size());
		userAlbum.setM_sAlbumDiary(diary);
		uas.addAlbumByUsrObj(user, userAlbum);
		map.put("time_distance", "0");
		map.put("address", "");
		map.put("praise_num", "0");
		map.put("comment_num", "0");
		map.put("forward_num", "0");
		JSONObject json = JSONObject.fromObject(map);
		releaseResult = json.toString();
		System.out.println("realeaseResult：" + releaseResult);
		for (int i = 0; i < images.size(); i++) {
			isSave = savePhoto(i);
			if (isSave == true) {
				count++;
			}
		}

		if (count == images.size()) {
			return UPLOAD_FINISH_ALL;
		} else if (count != images.size() && count > 0) {
			return UPLOAD_FINISH_NOT_ALL;
		} else {
			return UPLOAD_FAILURE;
		}
	}

	/**
	 * 上传图片
	 * 
	 * @return
	 */
	public boolean savePhoto(int i) {
		System.out.println("开始执行savePhoto！");
		try {
			File inFile = images.get(i);
			System.out.println("图片文件大小为：" + inFile.length());
			FileInputStream fis = new FileInputStream(inFile);
			String inFileName = FileNames.get(i);

			// 创建一个照片信息收集且持久化
			AlbumPhoto photo = new AlbumPhoto();
			photo.setM_DPhotoUploadTime(new Date(System.currentTimeMillis()));
			// 因为还没有创建UserAlbumService
			// String savePath = getSavePath() + File.separator +
			// (uas.getPhotoNum(album)+1) + inFileName;
			// //如何把savePath封装到AlbumPhoto中
			String savePath = getSavePath() + File.separator
					+ user.getM_sUserSignature()
					+ album.getM_DAlbumCreatedTime() + inFileName + (i + 1);
			System.out.println("savePath: " + savePath);
			photo.setM_SPhotoUrl(savePath);
			aps.addPhotoByAluObj(userAlbum, photo);

			// 文件不存在！
			File file = new File(savePath);
			System.out.println(file.getPath());

			if (!file.exists()) {
				System.out.println("图片不存在！");
				file.createNewFile();
			}
			FileOutputStream fos = new FileOutputStream(file);
			byte[] buffer = new byte[1024];
			int len = 0;
			System.out.println("开始buffer输出：");
			while ((len = fis.read(buffer)) > 0) {
				fos.write(buffer, 0, len);
			}
			System.out.println("len " + buffer.length);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 页面更新时：
	 * 检查是否有更新的动态并且返回更新的数据
	 */
	public void checkUpdateInformation(User user) {
		// 检查关注的用户是否有更新的消息
		List<UserFollow> userFollows = ufs.getAllUserFollow(user);
		
	}
	
	/**
	 * 当用户第一次登陆且今进入首页时
	 * @param user
	 */
	public void getAllInformationForDisplay(User user){
		List<UserFollow> userFollows = ufs.getAllUserFollow(user);
		
	}

	public String getLocation(File file) {
		System.out.println("开始执行getLocation方法!");
		String latitude = null;
		String longtitude = null;
		try {
			Metadata metadata = ImageMetadataReader.readMetadata(file);
			for (Directory directory : metadata.getDirectories()) {
				for (Tag tag : directory.getTags()) {
					String tagName = tag.getTagName();
					String desc = tag.getDescription();
					if (tagName.equals("GPS Latitude")) {
						latitude = desc;
					}
					if (tagName.equals("GPS Longitude")) {
						longtitude = desc;
					}
				}
			}
			if (latitude != null && longtitude != null) {
				return latitude + "," + longtitude;
			} else {
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

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<File> getImages() {
		return images;
	}

	public List<String> getFileNames() {
		return FileNames;
	}

	public void setFileNames(List<String> fileNames) {
		FileNames = fileNames;
	}

	public User getUser() {
		return user;
	}

	public void setUser() {
		this.user = (User) ServletActionContext.getServletContext()
				.getAttribute("user");
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
		System.out.println("getSavePath: "
				+ ServletActionContext.getServletContext()
						.getRealPath(savePath));
		return ServletActionContext.getServletContext().getRealPath(savePath);
	}

	// 从Struts.xml注入
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
}
