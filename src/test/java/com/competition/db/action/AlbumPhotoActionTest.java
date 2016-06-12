package com.competition.db.action;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AlbumPhotoActionTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testUploadPhotos() {
		AlbumPhotoAction albumPhoto = new AlbumPhotoAction();
		List<File> images = new ArrayList<>();
		File file_1 = new File("/Users/One/Desktop/TestImageOfMyProject/1.png");
		File file_2 = new File("/Users/One/Desktop/TestImageOfMyProject/2.png");
		images.add(file_1);
		images.add(file_2);
		albumPhoto.setImages(images);
	}

	@Test
	public void testSavePhoto() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetLocation() {
		fail("Not yet implemented");
	}

}
