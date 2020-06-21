package com.divitngoc.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.divitngoc.db.service.SongService;
import com.divitngoc.generated.tables.pojos.Song;
import com.divitngoc.model.SongRequest;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "v1/music")
public class MusicApiController {

	private final SongService songService;

	@GetMapping(value = "/songs")
	public ResponseEntity<List<Song>> getSongs(
			@RequestParam(value = "artistId", required = false) final String artistIdStr) {
		if (StringUtils.isEmpty(artistIdStr)) {
			return ResponseEntity.ok(songService.fetchAllSongs());
		}

		if (StringUtils.isNumeric(artistIdStr)) {
			return ResponseEntity.ok(songService.fetchSongsByArtistId(Integer.parseInt(artistIdStr)));
		} else {
			// TODO Redo Exception
			throw new RuntimeException();
		}
	}

	@PostMapping(value = "/songs")
	public ResponseEntity<Song> insertSong(@Valid @RequestBody final SongRequest songRequest) {
		Integer id = songService.insertSong(songRequest).orElseThrow(() -> new RuntimeException());
		Song song = new Song();
		song.setId(id);
		return ResponseEntity.status(HttpStatus.CREATED).body(song);
	}
}
