package com.goodTime.controller;

import java.util.List;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RestController;

import com.goodTime.model.Music;
import com.goodTime.serviceImplementation.MusicServiceImpl;

@RestController
@RequestMapping("api/music")
public class MusicController{
	
	@Autowired
	private MusicServiceImpl musicService;
	
	@PostMapping("/")
	private ResponseEntity<Music> createMusic(@RequestBody @Valid Music music){
		musicService.createMusic(music);
		return new ResponseEntity<Music>(music, HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	private ResponseEntity<List<Music>> getAllMusics(){
		List<Music> musics = musicService.getAllMusic();
		return new ResponseEntity<List<Music>>(musics, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	private ResponseEntity<Music> getMusic(@PathVariable("id") long id){
		Music music = musicService.getMusicById(id);
		return new ResponseEntity<Music>(music, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	private ResponseEntity<Music> deleteMusic(@PathVariable("id") long id){
		musicService.deleteMusic(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	private ResponseEntity<Music> updateMusic(@PathVariable("id") long id, @RequestBody Music song){
		Music music = musicService.updateMusic(id, song);
		return new ResponseEntity<Music>(music, HttpStatus.OK);
	}
}
