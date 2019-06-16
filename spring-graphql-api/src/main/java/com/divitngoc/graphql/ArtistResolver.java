package com.divitngoc.graphql;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.divitngoc.db.service.SongService;
import com.divitngoc.generated.tables.pojos.Artist;
import com.divitngoc.generated.tables.pojos.Song;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ArtistResolver implements GraphQLResolver<Artist> {

	private final SongService songService;

	public List<Song> getSongs(final Artist artist) {
		return songService.fetchSongsByArtistId(artist.getId());
	}

}