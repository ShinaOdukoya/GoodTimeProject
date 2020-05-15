package com.goodTime.repository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import com.goodTime.demainobject.MusicResponseObject;

@Repository
@RepositoryRestResource(collectionResourceRel = "musics", path="musics", excerptProjection=MusicResponseObject.class)
public interface MusicRepository {

}
