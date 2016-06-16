package com.competition.db.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class UserRefreshInformation {
	
	//主键
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_refresh_infromation_id",nullable=false)
	private String m_SURIid;
	
	//对应用户
	@ManyToOne(targetEntity=User.class)
	@JoinColumn(name="user_id", referencedColumnName="user_id")
	private User m_UUser;
	//更新时间
	@Column(name="user_refresh_information_time", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date m_DRefreshTime;
	
	//对应的ip地址
	@Column(name="user_refresh_information_ip", nullable=false)
	private String m_SIp;

	public User getM_UUser() {
		return m_UUser;
	}

	public void setM_UUser(User m_UUser) {
		this.m_UUser = m_UUser;
	}

	public Date getM_DRefreshTime() {
		return m_DRefreshTime;
	}

	public void setM_DRefreshTime(Date m_DRefreshTime) {
		this.m_DRefreshTime = m_DRefreshTime;
	}

	public String getM_SIp() {
		return m_SIp;
	}

	public void setM_SIp(String m_SIp) {
		this.m_SIp = m_SIp;
	}
}
