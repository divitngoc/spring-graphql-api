package com.divitngoc.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.divitngoc.db.service.SongService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(value = "v1/music")
public class MusicApiController {

	private final SongService songService;

	@GetMapping(value = "/songs")
	public ResponseEntity<?> getAllSongs() {
		return ResponseEntity.ok(songService.fetchAllSongs());
	}

}
