package com.divitngoc.db.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.divitngoc.db.dao.SongDao;
import com.divitngoc.db.service.factory.ServiceType;
import com.divitngoc.generated.tables.pojos.Song;
import com.divitngoc.model.SongRequest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class SongService implements MusicService {

	private final SongDao dao;
	private final ModelMapper modelMapper;

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

	/**
	 * 
	 * If created, returns an ID of the song created
	 * 
	 * @param songRequest
	 * @return
	 */
	public Optional<Integer> insertSong(SongRequest songRequest) {
		return Optional.ofNullable(dao.insert(modelMapper.map(songRequest, Song.class)));
	}

	@Override
	public ServiceType getType() {
		return ServiceType.SONG;
	}

}