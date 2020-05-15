package com.goodTime.serviceImplementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.goodTime.model.Music;
import com.goodTime.repository.MusicRepository;
import com.goodTime.service.MusicService;


@Service
public class MusicServiceImpl implements MusicService{
	
	@Autowired
	private MusicRepository musicRepository;

	@Override
	public void createMusic(Music music) {
		musicRepository.save(music);
	}

	@Override
	public void deleteMusic(long id) {
		musicRepository.deleteById(id);
	}

	@Override
	public Music updateMusic(long id, Music music) {
		return musicRepository.saveAndFlush(music);
	}

	@Override
	public Music getMusicById(long id) {
		return musicRepository.findById(id).get();
	}

	@Override
	public Music getMusicByName(String title) {
		return musicRepository.findByTitle(title);
	}

	@Override
	public List<Music> getAllMusic() {
		return musicRepository.findAll();
	}
}
