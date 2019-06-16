package com.divitngoc.db.dao;

import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import com.divitngoc.generated.Tables;
import com.divitngoc.generated.tables.pojos.Artist;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class ArtistDao {

	private final DSLContext dsl;

	public Artist fetchArtistById(final int id) {
		return dsl.selectFrom(Tables.ARTIST)
				.where(Tables.ARTIST.ID.eq(id))
				.fetchOneInto(Artist.class);
	}

}
