package com.goodTime.serviceImplementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goodTime.exception.BadRequestException;
import com.goodTime.exception.NotFoundException;
import com.goodTime.model.MusicPlaylist;
import com.goodTime.repository.MusicPlaylistRepository;
import com.goodTime.service.MusicPlaylistService;

@Service
public class MusicPlaylistServiceImpl implements MusicPlaylistService{
	
	
	@Autowired
	private MusicPlaylistRepository playlistRepo;

	@Override
	public void createPlaylist(MusicPlaylist playlist) {
		if(playlistRepo.findByName(playlist.getName()) !=null) {
			throw new BadRequestException("Music Playlist with title "+ playlist.getName()+" exists in database");
		}
		playlistRepo.save(playlist);
	}

	@Override
	public void deletePlaylist(long id) {
		playlistRepo.findById(id).orElseThrow(() -> new NotFoundException("Music Playlist with ID " + id + " not found!"));
		playlistRepo.deleteById(id);
	}

	@Override
	public MusicPlaylist updatePlaylist(long id, MusicPlaylist playlist) {
		playlistRepo.findById(id).orElseThrow(() -> new NotFoundException("Music Playlist with ID " + id + " not found!"));
		return playlistRepo.saveAndFlush(playlist);
	}

	@Override
	public MusicPlaylist getPlaylist(long id) {
		return playlistRepo
				.findById(id)
				.orElseThrow(() -> new NotFoundException("Music Playlist with ID " + id + " not found!"));
	}

	@Override
	public List<MusicPlaylist> getAllPlaylist() {
		List<MusicPlaylist> playlists = playlistRepo.findAll();
		if(playlists.isEmpty()) {
			throw new NotFoundException("Music Playlist database is empty!");
		}
		return playlists;
	}
}
