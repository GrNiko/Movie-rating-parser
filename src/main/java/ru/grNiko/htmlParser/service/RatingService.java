package ru.grNiko.htmlParser.service;

import ru.grNiko.htmlParser.entity.Rating;

import java.util.List;

public interface RatingService {
    void saveAll(List<Rating> ratingList);

    List<Rating> findAll();

    Iterable<Rating> findByDate(String filter);

}
