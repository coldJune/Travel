package com.competition.db.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="user_album")
public class UserAlbum{
	
	//主键
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="album_id",nullable=false)
	private int m_iAlbumId;
	
	//创建时间
	@Column(name="album_createdTime",nullable=true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date m_DAlbumCreatedTime;
	
	//赞次数
	@Column(name="album_praise")
	private int m_iAlbumPraise=0;
	
	//分享次数
	@Column(name="album_share")
	private int m_iAlbumShare=0;
	
	//日志
	@Column(name="album_diary",nullable=true)
	private String m_sAlbumDiary;
	
	//对应用户
	@ManyToOne(targetEntity=User.class)
	@JoinColumn(name="user_id",referencedColumnName="user_id",nullable=false)
	private User m_UAlbum_User;
	
	//评论数量
	@Column(name="album_commentsNum")
	private int m_iAlbumCommentsNum=0;
	
	//用户评论
	@OneToMany(targetEntity=AlbumComment.class,mappedBy="m_UA_Comements_UserAlbums")
	private Set<AlbumComment> m_UCAlbumComment = new HashSet<>();
	
	//用户相片
	@OneToMany(targetEntity=AlbumPhoto.class, mappedBy="m_UA_Photo_UserAlbum")
	private Set<AlbumPhoto> m_UPUserPhotos = new HashSet<>();
	
	@Column(name="album_photosNum")
	private int m_iPhotoNum=0;
	
	public Date getM_DAlbumCreatedTime() {
		return m_DAlbumCreatedTime;
	}

	public void setM_DAlbumCreatedTime(Date m_DAlbumCreatedTime) {
		this.m_DAlbumCreatedTime = m_DAlbumCreatedTime;
	}

	public int getM_iAlbumPraise() {
		return m_iAlbumPraise;
	}

	public void setM_iAlbumPraise(int m_iAlbumPraise) {
		this.m_iAlbumPraise = m_iAlbumPraise;
	}

	public int getM_iAlbumShare() {
		return m_iAlbumShare;
	}

	public void setM_iAlbumShare(int m_iAlbumShare) {
		this.m_iAlbumShare = m_iAlbumShare;
	}

	public String getM_sAlbumDiary() {
		return m_sAlbumDiary;
	}

	public void setM_sAlbumDiary(String m_sAlbumDiary) {
		this.m_sAlbumDiary = m_sAlbumDiary;
	}

	public User getM_UAlbum_User() {
		return m_UAlbum_User;
	}

	public void setM_UAlbum_User(User m_UAlbum_User) {
		this.m_UAlbum_User = m_UAlbum_User;
	}

	public int getM_iAlbumCommentsNum() {
		return m_iAlbumCommentsNum;
	}

	public void setM_iAlbumCommentsNum(int m_iAlbumCommentsNum) {
		this.m_iAlbumCommentsNum = m_iAlbumCommentsNum;
	}

	public Set<AlbumComment> getM_UCAlbumComment() {
		return m_UCAlbumComment;
	}

	public void setM_UCAlbumComment(Set<AlbumComment> m_UCAlbumComment) {
		this.m_UCAlbumComment = m_UCAlbumComment;
	}

	public Set<AlbumPhoto> getM_UPUserPhotos() {
		return m_UPUserPhotos;
	}

	public void setM_UPUserPhotos(Set<AlbumPhoto> m_UPUserPhotos) {
		this.m_UPUserPhotos = m_UPUserPhotos;
	}

	public int getM_iPhotoNum() {
		return m_iPhotoNum;
	}

	public void setM_iPhotoNum(int m_iPhotoNum) {
		this.m_iPhotoNum = m_iPhotoNum;
	}
}
