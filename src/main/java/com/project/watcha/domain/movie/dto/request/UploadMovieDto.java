package com.project.watcha.domain.movie.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.watcha.domain.movie.Movie;
import com.project.watcha.domain.movie.enumType.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UploadMovieDto {

    private String title;
    private String content;
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private List<MoviePeopleDto> moviePeople;
    private int time;
    private int spector;
    private int opening_date;
    private List<Genre> genre;

    public Movie toEntity(String image_url, String movie_url) {
        return Movie.builder()
                .title(title)
                .content(content)
                .time(time)
                .spectator(spector)
                .opening_date(opening_date)
                .genre(genre)
                .image_url("https://watcha-s3-bucket.s3.ap-northeast-2.amazonaws.com/movie_image/" + image_url)
                .movie_url("https://watcha-s3-bucket.s3.ap-northeast-2.amazonaws.com/movie/" + movie_url)
                .build();
    }
}
