package com.competition.db.pojo;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="album_comment")
public class AlbumComment{
	//主键
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="comment_id",nullable=false)
	private int m_iCommentId;
	
	//评论时间
	@Column(name="comment_time",nullable=true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date m_DCommentTime;
	
	//评论内容
	@Column(name="comment_content")
	private String m_sCommentContent;
	
	//对应相册集
	@ManyToOne(targetEntity=UserAlbum.class)
	@JoinColumn(name="album_id",referencedColumnName="album_id")
	private UserAlbum m_UA_Comements_UserAlbums;

	public Date getM_DCommentTime() {
		return m_DCommentTime;
	}

	public void setM_DCommentTime(Date m_DCommentTime) {
		this.m_DCommentTime = m_DCommentTime;
	}

	public String getM_sCommentContent() {
		return m_sCommentContent;
	}

	public void setM_sCommentContent(String m_sCommentContent) {
		this.m_sCommentContent = m_sCommentContent;
	}

	public UserAlbum getM_UA_Comements_UserAlbums() {
		return m_UA_Comements_UserAlbums;
	}

	public void setM_UA_Comements_UserAlbums(UserAlbum m_UA_Comements_UserAlbums) {
		this.m_UA_Comements_UserAlbums = m_UA_Comements_UserAlbums;
	}


}
