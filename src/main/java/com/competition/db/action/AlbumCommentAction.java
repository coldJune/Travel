package com.competition.db.action;

import com.competition.db.pojo.AlbumComment;
import com.competition.db.pojo.UserAlbum;
import com.competition.db.service.AlbumCommentService;
import com.opensymphony.xwork2.ActionSupport;

public class AlbumCommentAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = -919526399725376731L;
	private AlbumCommentService acs;
	private UserAlbum album;
	private AlbumComment comment;
	
	

public AlbumCommentService getAcs() {
		return acs;
	}

	public void setAcs(AlbumCommentService acs) {
		this.acs = acs;
	}

	public UserAlbum getAlbum() {
		return album;
	}

	public void setAlbum(UserAlbum album) {
		this.album = album;
	}

	public AlbumComment getComment() {
		return comment;
	}

	public void setComment(AlbumComment comment) {
		this.comment = comment;
	}

/**
 * 向 相册添加评论
 * @return Success 返回成功跳转到照片主页
 * @throws Exception
 */
	public String addComment()throws Exception{
				acs.addCommentByAluObj(album);
				return SUCCESS;
		}
	/**
	 * 删除相册的评论
	 * @return SUCCESS 返回成功跳转照片主页
	 * @throws Exception
	 */
	public String deleteComment()throws Exception{
		acs.deleteCommentByComObj(comment);
		return SUCCESS;
	}
	
	public String findComment()throws Exception{
		acs.findAllCommentByAluObj(album);
		return SUCCESS;
	}
}
