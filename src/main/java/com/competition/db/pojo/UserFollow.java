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
@Table(name="user_follow")
public class UserFollow {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_follow_id",nullable=false)
	private int m_iUserId;
	
	/**
	 * 添加日期，目前暂时以添加时间作为优先级显示
	 */
	@Column(name="follow_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date m_DUserFollowDate;
	
	//对应用户
	@ManyToOne(targetEntity=User.class)
	@JoinColumn(name="user_id", referencedColumnName="user_id", nullable=false)
	private User m_UUser;

	public Date getM_DUserFollowDate() {
		return m_DUserFollowDate;
	}

	public void setM_DUserFollowDate(Date m_DUserFollowDate) {
		this.m_DUserFollowDate = m_DUserFollowDate;
	}

	public User getM_UUser() {
		return m_UUser;
	}

	public void setM_UUser(User m_UUser) {
		this.m_UUser = m_UUser;
	}
}
