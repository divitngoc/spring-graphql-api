package com.divitngoc.model;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SongRequest {

	@NotBlank(message = "Title must not be null/blank")
	private String title;
	private String summary;
	private String lyrics;
	private LocalDate publishedDate;

}
