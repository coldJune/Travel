package com.competition.db.pojo;



import java.sql.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_collection")
public class UserCollection{
	
	//主键
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int m_iCollectionId;
	
	//收藏日期
	private Date m_DCollectionDate;
	
	//对应相册
	@OneToOne(targetEntity=UserAlbum.class)
	@JoinColumn(name="album_id",referencedColumnName="album_id", unique=true)
	private UserAlbum m_UAAlbums;
	
	//对应用户
	@ManyToOne(targetEntity=User.class)
	@JoinColumn(name="user_id", referencedColumnName="user_id")
	private User m_UUser;

	public Date getM_DCollectionDate() {
		return m_DCollectionDate;
	}

	public void setM_DCollectionDate(Date m_DCollectionDate) {
		this.m_DCollectionDate = m_DCollectionDate;
	}

	public UserAlbum getM_UAAlbums() {
		return m_UAAlbums;
	}

	public void setM_UAAlbums(UserAlbum m_UAAlbums) {
		this.m_UAAlbums = m_UAAlbums;
	}

	public User getM_UUser() {
		return m_UUser;
	}

	public void setM_UUser(User m_UUser) {
		this.m_UUser = m_UUser;
	}
}
