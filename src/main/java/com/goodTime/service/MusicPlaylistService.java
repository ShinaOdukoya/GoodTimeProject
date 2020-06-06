package com.goodTime.service;

import java.util.List;
import com.goodTime.model.Music;
import com.goodTime.model.MusicPlaylist;

public interface MusicPlaylistService {
	
	void createPlaylist(MusicPlaylist playlist);
	void deletePlaylist(long id);
	void addMusic(MusicPlaylist playlist, Music music);
	MusicPlaylist updatePlaylist(long id, MusicPlaylist playlist);
	MusicPlaylist getPlaylistById(long id);
	MusicPlaylist getPlaylistByName(String name);
	List<MusicPlaylist> getAllPlaylist();
}
