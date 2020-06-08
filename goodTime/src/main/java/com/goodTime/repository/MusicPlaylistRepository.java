package com.goodTime.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.goodTime.model.MusicPlaylist;


@Repository
public interface MusicPlaylistRepository extends JpaRepository<MusicPlaylist, Long>{
	
	MusicPlaylist findByName(String title);

}
