package com.goodTime.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.goodTime.domainobject.MusicResponseObject;
import com.goodTime.model.Music;

@Repository
@RepositoryRestResource(collectionResourceRel = "musics", path="musics", excerptProjection=MusicResponseObject.class)
public interface MusicRepository extends JpaRepository<Music, Long>{
	
	Music findByTitle(String title);

}
