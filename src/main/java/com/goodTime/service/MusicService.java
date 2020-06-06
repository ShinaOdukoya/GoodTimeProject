package com.goodTime.service;

import java.util.List;

import com.goodTime.model.Music;

public interface MusicService {
	
	void createMusic(Music music);
	void deleteMusic(long id);
	Music updateMusic(long id, Music music);
	Music getMusicById(long id);
	Music getMusicByName(String title);
	List<Music> getAllMusic();

}
