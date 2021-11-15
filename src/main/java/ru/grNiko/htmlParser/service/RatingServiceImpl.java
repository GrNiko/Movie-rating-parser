package ru.grNiko.htmlParser.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.grNiko.htmlParser.entity.Rating;
import ru.grNiko.htmlParser.repo.RatingRepo;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class RatingServiceImpl implements RatingService {


    private RatingRepo ratingRepo;

    public void saveAll(List<Rating> ratingList) {
        ratingRepo.saveAll(ratingList);
    }

    @Override
    public Iterable<Rating> findByDate(String filter) {

        List<Rating> allMovies = ratingRepo.findAll();

        List<Rating> moviesByDate = new ArrayList<>();
        for (Rating rating : allMovies) {
            if (rating.getDate().toString().equals(filter)) {
                moviesByDate.add(rating);
            }
        }
        return moviesByDate;
    }
}
