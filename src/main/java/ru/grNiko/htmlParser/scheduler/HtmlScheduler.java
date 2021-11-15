package ru.grNiko.htmlParser.scheduler;

import lombok.SneakyThrows;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.grNiko.htmlParser.entity.Rating;
import ru.grNiko.htmlParser.service.HtmlService;
import ru.grNiko.htmlParser.service.RatingService;

import java.util.ArrayList;
import java.util.List;

@Component
public class HtmlScheduler {

    @Autowired
    RatingService ratingService;

    private static final String EVERY_DAY = "0 0 0 * * ?";
    private static final String EVERY_MIN = "0 * * ? * *";
    private static final String URL = "http://kinopoisk.ru/top";
    private static final Integer MOVIE_COUNT = 10;
    private static final String NAME_ROOT = "selection-film-item-meta__link";
    private static final String NAME_ORIGINAL = "selection-film-item-meta__original-name";
    private static final String NAME_TRANSLATED = "selection-film-item-meta__name";
    private static final String RATING_ROOT = "film-item-user-data__rating";
    private static final String RATING_VALUE = "rating__value_positive";
    private static final String RATING_COUNT = "rating__count";

    @SneakyThrows
    @Scheduled(cron = EVERY_MIN)
    public void parseRating() {


        List<Rating> ratingList = new ArrayList<>();
        Document document = HtmlService.getDocumentByUrl(URL);

        Elements movieName = document.getElementsByClass(NAME_ROOT);
        Elements movieRating = document.getElementsByClass(RATING_ROOT);
        for (int i = 0; i < MOVIE_COUNT; i++) {
            String originalName = movieName.get(i).getElementsByClass(NAME_ORIGINAL).text();
            String rusName = movieName.get(i).getElementsByClass(NAME_TRANSLATED).text();

            Integer moviePosition = i + 1;
            String ratingValue = movieRating.get(i).getElementsByClass(RATING_VALUE).text();
            String ratingCount = movieRating.get(i).getElementsByClass(RATING_COUNT).text();

            String finalName;
            if (originalName.matches("[0-9 ]+")) {
                finalName = rusName + ", " + originalName;
            } else {
                finalName = originalName;
            }

            ratingList.add(new Rating(moviePosition, ratingValue, finalName, ratingCount));
        }

        System.out.println(ratingList.get(0).getDate().toString());
        ratingService.saveAll(ratingList);

    }
}