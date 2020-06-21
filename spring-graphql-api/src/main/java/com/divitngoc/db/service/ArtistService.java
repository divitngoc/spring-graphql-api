package com.divitngoc.db.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.divitngoc.db.dao.ArtistDao;
import com.divitngoc.generated.tables.pojos.Artist;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ArtistService {

	private final ArtistDao dao;

	public Optional<Artist> fetchArtistById(final int id) {
		log.info("Fetching artist by id: {}", id);
		if (id > 0) {
			return Optional.ofNullable(dao.fetchArtistById(id));
		}

		return Optional.empty();
	}
}
