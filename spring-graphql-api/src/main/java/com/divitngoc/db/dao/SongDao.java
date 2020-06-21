package com.divitngoc.db.dao;

import java.util.List;

import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import com.divitngoc.generated.Tables;
import com.divitngoc.generated.tables.pojos.Song;
import com.divitngoc.generated.tables.records.SongRecord;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class SongDao {

	private final DSLContext dsl;

	public List<Song> fetchAllSongs() {
		return dsl.selectFrom(Tables.SONG).fetchInto(Song.class);
	}

	public List<Song> fetchSongsByArtistId(final int artistId) {
		return dsl.selectFrom(Tables.SONG)
				  .where(Tables.SONG.ARTIST_ID.eq(artistId))
				  .fetchInto(Song.class);
	}

	public Integer insert(Song song) {
		final SongRecord record = dsl.newRecord(Tables.SONG, song);
		record.insert();
		return record.getId();
	}

}
