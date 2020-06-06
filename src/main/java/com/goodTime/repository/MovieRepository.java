package com.goodTime.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.goodTime.domainobject.MovieResponseObject;
import com.goodTime.model.Movie;

@Repository
@RepositoryRestResource(collectionResourceRel = "movies", path="movies", excerptProjection=MovieResponseObject.class)
public interface MovieRepository extends JpaRepository<Movie,Long> {

}
