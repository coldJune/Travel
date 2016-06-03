package com.competition.db.dao.impl;



import java.util.ArrayList;
import java.util.List;
import java.util.Set;



import com.competition.db.common.BasicOperation;
import com.competition.db.dao.AlbumPhotoDao;
import com.competition.db.pojo.AlbumPhoto;
import com.competition.db.pojo.UserAlbum;


public class AlbumPhotoDaoImpl extends BasicOperation<AlbumPhoto> implements AlbumPhotoDao{

	/**
	 * 根据UserAlbum和AlbumPhoto对象添加照片
	 */
	@Override
	public void addPhotoByAluObj(UserAlbum album,AlbumPhoto photo) {
		// TODO Auto-generated method stub
		photo.setM_UA_Photo_UserAlbum(album);
		getSessionFactory().getCurrentSession().save(photo);
	}

	@Override
	public void deletePhotoByPhtObj(AlbumPhoto photo) {
		// TODO Auto-generated method stub
		getSessionFactory().getCurrentSession().delete(photo);
	}

	@Override
	public List<AlbumPhoto> findAllPhotoByAluObj(UserAlbum album) {
		// TODO Auto-generated method stub
		Set<AlbumPhoto> photos_set = album.getM_UPUserPhotos();
		List<AlbumPhoto> photos_list = new ArrayList<AlbumPhoto>();
		for(AlbumPhoto ele: photos_set){
			photos_list.add(ele);
		}
		return photos_list;
	}

	@Override
	public void updatePhotoByAluObj(UserAlbum album, AlbumPhoto photo) {
		// TODO Auto-generated method stub
		photo.setM_UA_Photo_UserAlbum(album);
		getSessionFactory().getCurrentSession().save(photo);
	}

	

}

