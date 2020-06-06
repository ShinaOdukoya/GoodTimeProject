package com.goodTime.serviceImplementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goodTime.exception.BadRequestException;
import com.goodTime.exception.NotFoundException;
import com.goodTime.model.Music;
import com.goodTime.repository.MusicRepository;
import com.goodTime.service.MusicService;


@Service
public class MusicServiceImpl implements MusicService{
	
	@Autowired
	private MusicRepository musicRepository;

	@Override
	public void createMusic(Music music) {
		if(musicRepository.findByTitle(music.getTitle()) != null){
			throw new BadRequestException("Music with title "+music.getTitle()+" already exist!");
		}
		musicRepository.save(music);
	}

	@Override
	public void deleteMusic(long id) {
		getMusicById(id);
		musicRepository.deleteById(id);
	}

	@Override
	public Music updateMusic(long id, Music music) {
		Music existingMusic = getMusicById(id);
		if(music.getTitle() != null) {
			existingMusic.setTitle(music.getTitle());
		}
		if(music.getArtist() != null) {
			existingMusic.setArtist(music.getArtist());
		}
		if(music.getArtist() != null) {
			existingMusic.setAlbum(music.getAlbum());
		}
		return musicRepository.saveAndFlush(existingMusic);
	}

	@Override
	public Music getMusicById(long id) {
		return musicRepository
				.findById(id)
				.orElseThrow(() -> new NotFoundException("Music with ID "+id+" not found!"));
	}

	@Override
	public Music getMusicByName(String title) {
		if(musicRepository.findByTitle(title) == null) {
			throw new NotFoundException("Music with title "+title+" not found!");
		}
		return musicRepository.findByTitle(title);
	}

	@Override
	public List<Music> getAllMusic() {
		if(musicRepository.findAll().isEmpty()) {
			throw new NotFoundException("Music database is empty!");
		}
		return musicRepository.findAll();
	}
}
