package com.goodTime.serviceImplementation;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goodTime.controller.MusicPlaylistController;
import com.goodTime.exception.BadRequestException;
import com.goodTime.exception.NotFoundException;
import com.goodTime.model.Music;
import com.goodTime.model.MusicPlaylist;
import com.goodTime.repository.MusicPlaylistRepository;
import com.goodTime.repository.UserRepository;
import com.goodTime.service.MusicPlaylistService;

@Service
public class MusicPlaylistServiceImpl implements MusicPlaylistService{
	
	
	@Autowired
	private MusicPlaylistRepository playlistRepo;
	
	@Autowired
	private UserRepository userRepository;
	
	Logger logger = LoggerFactory.getLogger(MusicPlaylistController.class);

	@Override
	public void createPlaylist(MusicPlaylist playlist) {
		getPlaylistByName(playlist.getName());
		playlist.setUsers(userRepository.findByEmailAddress("adetosine6@gmail.com"));
		playlistRepo.save(playlist);
	}

	@Override
	public void deletePlaylist(long id) {
		getPlaylistById(id);
		playlistRepo.deleteById(id);
	}

	@Override
	public MusicPlaylist updatePlaylist(long id, MusicPlaylist playlist) {
		getPlaylistById(id);
		return playlistRepo.saveAndFlush(playlist);
	}

	@Override
	public MusicPlaylist getPlaylistById(long id) {
		return playlistRepo
				.findById(id)
				.orElseThrow(() -> new NotFoundException("Music Playlist with ID "+id+" not found!"));
	}

	@Override
	public List<MusicPlaylist> getAllPlaylist() {
		List<MusicPlaylist> playlists = playlistRepo.findAll();
		if(playlists.isEmpty()) {
			throw new NotFoundException("Music Playlist database is empty!");
		}
		return playlists;
	}

	@Override
	public MusicPlaylist getPlaylistByName(String name) {
		if(playlistRepo.findByName(name) !=null) {
			throw new BadRequestException("Music Playlist with title "+name+" exists in database");
		}
		return playlistRepo.findByName(name);
	}

	@Override
	public void addMusic(MusicPlaylist playlist, Music music) {
		playlist.getMusic().add(music);
		logger.info(music.getTitle()+" has been added to playlist "+playlist.getName());
		playlistRepo.saveAndFlush(playlist);
	}
}
