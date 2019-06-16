package com.divitngoc.graphql;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.divitngoc.db.service.SongService;
import com.divitngoc.generated.tables.pojos.Song;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Query implements GraphQLQueryResolver {

	private final SongService songService;

	public List<Song> fetchAllSongs() {
		return songService.fetchAllSongs();
	}

	public List<Song> fetchSongsByArtistId(int artistId)
	{
		return songService.fetchSongsByArtistId(artistId);
	}
}
