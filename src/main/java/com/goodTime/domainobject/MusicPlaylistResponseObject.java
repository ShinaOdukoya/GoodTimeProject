package com.goodTime.domainobject;

import org.springframework.data.rest.core.config.Projection;

import com.goodTime.model.Music;
import com.goodTime.model.MusicPlaylist;

@Projection(name="musicPlaylistDetails", types= {MusicPlaylist.class})
public interface MusicPlaylistResponseObject {
	
	String getName();
	String getRating();
	Music getMusic();

}
