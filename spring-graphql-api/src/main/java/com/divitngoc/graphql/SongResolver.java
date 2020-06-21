package com.divitngoc.graphql;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.divitngoc.db.service.ArtistService;
import com.divitngoc.generated.tables.pojos.Artist;
import com.divitngoc.generated.tables.pojos.Song;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SongResolver implements GraphQLResolver<Song> {

	private final ArtistService artistService;

	public Artist getArtist(final Song song) {
		return artistService.fetchArtistById(song.getArtistId()).orElse(null);
	}

}
