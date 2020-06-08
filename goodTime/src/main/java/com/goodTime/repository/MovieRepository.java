package com.goodTime.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import com.goodTime.demainobject.MovieResponseObject;
import com.goodTime.model.Movie;

@Repository
@RepositoryRestResource(collectionResourceRel = "movies", path="moviws", excerptProjection=MovieResponseObject.class)
public interface MovieRepository extends JpaRepository<Movie,Long> {

}
