package com.goodTime.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import com.goodTime.domainobject.MusicPlaylistResponseObject;
import com.goodTime.model.MusicPlaylist;


@Repository
@RepositoryRestResource(collectionResourceRel = "music-playlist", path="music-playlist", excerptProjection=MusicPlaylistResponseObject.class)
public interface MusicPlaylistRepository extends JpaRepository<MusicPlaylist, Long>{
	
	MusicPlaylist findByName(String title);

}
