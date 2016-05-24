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
@Table(name="user_background")
public class UserBackground{
	
	//主键
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="background_id",nullable=false)
	private int m_iBackgroundId;
	
	//背景添加时间
	@Column(name="background_addedTime",nullable=true)
	private Date m_DBackgroundAddedTime;
	
	//对应的图片存储的URL
	@Column(name="background_imageUrl",nullable=true)
	private String m_SBackgroundImageUrl;
	
	//对应的用户
	@ManyToOne(targetEntity=User.class)
	@JoinColumn(name="user_id",referencedColumnName="user_id",nullable=false)
	private User m_UUser;

	public Date getM_DBackgroundAddedTime() {
		return m_DBackgroundAddedTime;
	}

	public void setM_DBackgroundAddedTime(Date m_DBackgroundAddedTime) {
		this.m_DBackgroundAddedTime = m_DBackgroundAddedTime;
	}

	public String getM_SBackgroundImageUrl() {
		return m_SBackgroundImageUrl;
	}

	public void setM_SBackgroundImageUrl(String m_SBackgroundImageUrl) {
		this.m_SBackgroundImageUrl = m_SBackgroundImageUrl;
	}

	public User getM_UUser() {
		return m_UUser;
	}

	public void setM_UUser(User m_UUser) {
		this.m_UUser = m_UUser;
	}
}

