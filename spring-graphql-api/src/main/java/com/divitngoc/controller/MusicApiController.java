package com.divitngoc.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.divitngoc.db.service.SongService;
import com.divitngoc.db.service.factory.MusicServiceFactory;
import com.divitngoc.db.service.factory.ServiceType;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(value = "v1/music")
public class MusicApiController {

	private final MusicServiceFactory serviceFactory;

	@GetMapping(value = "/songs")
	public ResponseEntity<?> getAllSongs() {
		return ResponseEntity.ok(serviceFactory.getInstance(ServiceType.SONG, SongService.class).fetchAllSongs());
	}

}
