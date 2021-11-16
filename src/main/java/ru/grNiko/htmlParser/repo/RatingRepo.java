package ru.grNiko.htmlParser.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.grNiko.htmlParser.entity.Rating;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RatingRepo extends JpaRepository <Rating, Long> {
    List<Rating> findAllByDate(LocalDate date);
}
