package com.goodTime.service;

import java.util.List;

import com.goodTime.model.MusicPlaylist;

public interface MusicPlaylistService {
	
	
	void createPlaylist(MusicPlaylist playlist);
	void deletePlaylist(long id);
	MusicPlaylist updatePlaylist(long id, MusicPlaylist playlist);
	MusicPlaylist getPlaylist(long id);
	List<MusicPlaylist> getAllPlaylist();
}
