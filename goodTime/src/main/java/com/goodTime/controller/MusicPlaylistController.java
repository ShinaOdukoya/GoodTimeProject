package com.goodTime.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.goodTime.model.Music;
import com.goodTime.model.MusicPlaylist;
import com.goodTime.serviceImplementation.MusicPlaylistServiceImpl;
import com.goodTime.serviceImplementation.MusicServiceImpl;

@RestController
@RequestMapping("api/music-playlist")
public class MusicPlaylistController {
	
	@Autowired
	private MusicPlaylistServiceImpl musicPlaylistService;
	
	@Autowired
	private MusicServiceImpl musicService;
	
	@PostMapping("/")
	private ResponseEntity<MusicPlaylist> createPlaylist(@RequestBody MusicPlaylist playlist){
		musicPlaylistService.createPlaylist(playlist);
		return new ResponseEntity<MusicPlaylist>(playlist, HttpStatus.CREATED) ;
	}
	
	@GetMapping("/")
	private ResponseEntity<List<MusicPlaylist>> viewPlaylists(){
		List<MusicPlaylist> playlists = musicPlaylistService.getAllPlaylist();
		return new ResponseEntity<List<MusicPlaylist>>(playlists, HttpStatus.OK) ;
	}
	
	@GetMapping("/{id}")
	private ResponseEntity<MusicPlaylist> getPlaylist(@PathVariable("id") long id){
		MusicPlaylist playlist = musicPlaylistService.getPlaylistById(id);
		return new ResponseEntity<MusicPlaylist>(playlist, HttpStatus.OK) ;
	}
	
	@PutMapping("/{id}")
	private ResponseEntity<MusicPlaylist> updatePlaylist(@PathVariable("id") long id, @RequestBody MusicPlaylist playlist){
		MusicPlaylist playlistMusic = musicPlaylistService.updatePlaylist(id, playlist);
		return new ResponseEntity<MusicPlaylist>(playlistMusic, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	private ResponseEntity<MusicPlaylist> deletePlaylist(@PathVariable("id") long id){
		musicPlaylistService.deletePlaylist(id);
		return new ResponseEntity<MusicPlaylist>(HttpStatus.OK);
	}
	
	@PostMapping("/add-music")
	private ResponseEntity<MusicPlaylist> addSong(@RequestParam("playlistId") long playlistId, @RequestParam("musicId") long musicId){
		MusicPlaylist playlist = musicPlaylistService.getPlaylistById(playlistId);
		Music music = musicService.getMusicById(musicId);
		
		musicPlaylistService.addMusic(playlist, music);
		return new ResponseEntity<MusicPlaylist>(HttpStatus.OK);
	}
}
