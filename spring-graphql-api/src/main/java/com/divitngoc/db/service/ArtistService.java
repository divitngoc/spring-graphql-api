package com.divitngoc.db.service;

import org.springframework.stereotype.Service;

import com.divitngoc.db.dao.ArtistDao;
import com.divitngoc.generated.tables.pojos.Artist;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class ArtistService {

	private final ArtistDao dao;

	public Artist fetchArtistById(final int id) {
		log.info("Fetching artist by id: {}", id);

		if (id > 0) {
			return dao.fetchArtistById(id);
		}
		return null;
	}
}
