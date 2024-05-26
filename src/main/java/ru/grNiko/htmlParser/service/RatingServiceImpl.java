package ru.grNiko.htmlParser.service;

import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import ru.grNiko.htmlParser.dto.RatingDTO;
import ru.grNiko.htmlParser.entity.Rating;
import ru.grNiko.htmlParser.repo.RatingRepo;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class RatingServiceImpl implements RatingService {

    @Override
    public void saveAll(List<RatingDTO> ratingList) {
        var ratings = ratingList.stream()
                .map(mapRatingToEntity)
                .collect(Collectors.toList());
        ratingRepo.saveAll(ratings);
    }

    private RatingRepo ratingRepo;

    @Override
    @Cacheable(cacheNames = "ratingsByDate")
    public List<RatingDTO> findByDate(LocalDate filterDate) {

        if (filterDate == null) {
            return Collections.emptyList();
        }
        return ratingRepo.findAllByDate(filterDate).stream()
                .map(mapRatingToDTO)
                .collect(Collectors.toList());
    }


    private final Function<RatingDTO, Rating> mapRatingToEntity = (dto) -> new Rating(

            0L,
            dto.getPosition(),
            dto.getRating(),
            dto.getName(),
            dto.getVoteCount(),
            LocalDate.now()
    );


    private final Function<Rating, RatingDTO> mapRatingToDTO = (rating) -> RatingDTO.builder()
            .position(rating.getPosition())
            .rating(rating.getRating())
            .name(rating.getName())
            .voteCount(rating.getVoteCount())
            .date(rating.getDate())
            .build();

}
