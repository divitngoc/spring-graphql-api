package com.divitngoc.db.service;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.divitngoc.db.dao.SongDao;
import com.divitngoc.generated.tables.pojos.Song;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class SongService {

	private final SongDao dao;

	public List<Song> fetchAllSongs() {
		log.info("Fetching all songs");
		return dao.fetchAllSongs();
	}

	public List<Song> fetchSongsByArtistId(final int artistId) {
		log.info("Fetching song by artistId: {}", artistId);

		if (artistId > 0) {
			return dao.fetchSongsByArtistId(artistId);
		}
		return Collections.emptyList();
	}

}
