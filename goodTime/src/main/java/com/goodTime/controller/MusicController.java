package com.goodTime.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goodTime.model.Music;
import com.goodTime.serviceImplementation.MusicServiceImpl;

@RestController
@RequestMapping("api/music")
public class MusicController{
	
	@Autowired
	private MusicServiceImpl musicService;
	
	@PostMapping("/")
	private ResponseEntity<Music> createMusic(@RequestBody Music music){
		musicService.createMusic(music);
		return new ResponseEntity<Music>(music, HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	private ResponseEntity<List<Music>> getMusics(){
		List<Music> musics = musicService.getAllMusic();
		return new ResponseEntity<List<Music>>(musics, HttpStatus.OK);
	}
}
