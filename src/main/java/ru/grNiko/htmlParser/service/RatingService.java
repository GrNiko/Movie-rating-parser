package ru.grNiko.htmlParser.service;

import ru.grNiko.htmlParser.dto.RatingDTO;

import java.time.LocalDate;
import java.util.List;

public interface RatingService {

    void saveAll(List<RatingDTO> ratingList);

    List<RatingDTO> findByDate(LocalDate filterDate);
}
