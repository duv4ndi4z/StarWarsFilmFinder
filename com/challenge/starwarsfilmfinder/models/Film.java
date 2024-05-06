package com.challenge.starwarsfilmfinder.models;

public record Film(String title,
                   int episode_id,
                   String director,
                   String producer,
                   String release_date) {
}
