package ru.grNiko.htmlParser.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.grNiko.htmlParser.entity.Rating;

@Repository
public interface RatingRepo extends JpaRepository <Rating, Long> {

}
