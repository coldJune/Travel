package com.competition.db.pojo;

import java.sql.Blob;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="album_photo")
public class AlbumPhoto{
	//主键
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="photo_id",nullable=false)
	private int m_iUserPhotoId;
	
	//用户上传照片时间
	@Column(name="photo_uploadTime",nullable=true)
	private Date m_DPhotoUploadTime;
	
	//照片内容
	@Column(name="photo_photoUrl", nullable=true)
	private String m_SPhotoUrl;
		
	//对应的相册
	@ManyToOne(targetEntity=UserAlbum.class)
	@JoinColumn(name="album_id",referencedColumnName="album_id")
	private UserAlbum m_UA_Photo_UserAlbum;

	public Date getM_DPhotoUploadTime() {
		return m_DPhotoUploadTime;
	}

	public void setM_DPhotoUploadTime(Date m_DPhotoUploadTime) {
		this.m_DPhotoUploadTime = m_DPhotoUploadTime;
	}

	public String getM_SPhotoUrl() {
		return m_SPhotoUrl;
	}

	public void setM_SPhotoUrl(String m_SPhotoUrl) {
		this.m_SPhotoUrl = m_SPhotoUrl;
	}

	public UserAlbum getM_UA_Photo_UserAlbum() {
		return m_UA_Photo_UserAlbum;
	}

	public void setM_UA_Photo_UserAlbum(UserAlbum m_UA_Photo_UserAlbum) {
		this.m_UA_Photo_UserAlbum = m_UA_Photo_UserAlbum;
	}
}

