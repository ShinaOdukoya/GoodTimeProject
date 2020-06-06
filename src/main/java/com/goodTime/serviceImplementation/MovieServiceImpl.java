package com.goodTime.serviceImplementation;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.goodTime.exception.NotFoundException;
import com.goodTime.model.Movie;
import com.goodTime.repository.MovieRepository;
import com.goodTime.service.MovieService;



@Service
public class MovieServiceImpl implements MovieService {
	
	@Autowired
	private MovieRepository movieRepository;
	
	
	@Override
	public void addMovie(Movie movie) {
		
		movieRepository.save(movie);
	}
	
	@Override
	public List<Movie> fetchAllMovies(){
		return movieRepository.findAll();
	}
	
	@Override
	public Movie findMovieById(Long id) {
		
		if(movieRepository.findById(id).isPresent()) {
			
			return movieRepository.getOne(id);
			
		}else {
			
			return null;
		}
	}
	
//	@Override
//	public List<Movie> createPlaylist(UUID userId, Long id){
//		
//		List<Movie> movies = fetchAllMovies();
//		User user = userRepository.getOne(userId);
//		List<Movie> movieplaylist = new ArrayList<>();
//		
//		user.setMovies(movieplaylist);
//		userRepository.save(user);
//		return movies;	
//	}

	public Movie updateMovie(Long id, Movie movie) {
		
		if(movieRepository.findById(id).isPresent()) {
			
			Movie existingMovie = movieRepository.findById(id).get();
			
			existingMovie.setTitle(movie.getTitle());
			
			existingMovie.setDescription(movie.getDescription());
			
			Movie newMovie = movieRepository.save(existingMovie);
			
			return newMovie;
		}else {
			throw new NotFoundException("Movie with ID"+id+ "does not exist");
			
		}
	
	}
	
	@Override
	public void deleteMovieById(Long id) {
		if(movieRepository.findById(id).isEmpty())
			throw new NotFoundException("Movie with ID "+id+" does not exist!");
		movieRepository.deleteById(id);
	}
}
