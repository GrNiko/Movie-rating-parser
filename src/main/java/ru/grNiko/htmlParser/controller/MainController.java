package ru.grNiko.htmlParser.controller;

import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.grNiko.htmlParser.dto.RatingDTO;
import ru.grNiko.htmlParser.service.RatingService;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Controller
public class MainController {

    private RatingService ratingService;

    @GetMapping("/")
    public String root() {
        return "main";
    }

    @PostMapping
    public String inputResult(Map<String, Object> model,
                              @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate filter) {
        List<RatingDTO> movies;
        if (filter != null) {
            movies = ratingService.findByDate(filter);
        } else {
            return "main";
        }
        model.put("movies", movies);
        model.put("filter", filter);
        return "main";
    }
}
