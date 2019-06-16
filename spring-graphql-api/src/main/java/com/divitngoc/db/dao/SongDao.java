package com.divitngoc.db.dao;

import java.util.List;

import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import com.divitngoc.generated.Tables;
import com.divitngoc.generated.tables.pojos.Song;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class SongDao {

	private final DSLContext dsl;

	public List<Song> fetchAllSongs() {
		return dsl.selectFrom(Tables.SONG)
				.fetchInto(Song.class);
	}

	public List<Song> fetchSongsByArtistId(final int artistId) {
		return dsl.selectFrom(Tables.SONG)
				.where(Tables.SONG.ARTIST_ID.eq(artistId))
				.fetchInto(Song.class);
	}

}
